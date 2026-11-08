
USE StayEase;

-- 1. View: Complete booking information
CREATE OR REPLACE VIEW BookingDetails AS
SELECT
    b.BookingID,
    c.FullName AS CustomerName,
    c.Email,
    h.HotelName,
    hb.BranchName,
    b.CheckInDate,
    b.CheckOutDate,
    b.BookingStatus
FROM Booking b
JOIN Customer c ON b.CustomerID = c.CustomerID
JOIN HotelBranch hb ON b.BranchID = hb.BranchID
JOIN Hotel h ON hb.HotelID = h.HotelID;

-- 2. View: Successful payment summary
CREATE OR REPLACE VIEW SuccessfulPayments AS
SELECT
    BookingID,
    SUM(Amount) AS TotalPaid
FROM Payment
WHERE PaymentStatus = 'SUCCESS'
GROUP BY BookingID;

-- Verify views
SELECT * FROM BookingDetails;
SELECT * FROM SuccessfulPayments;

-- 3. PROCEDURE: Get bookings by customer ID
DROP PROCEDURE IF EXISTS GetCustomerBookings;

DELIMITER $$

CREATE PROCEDURE GetCustomerBookings(
    IN p_CustomerID INT
)
BEGIN
    SELECT
        b.BookingID,
        c.FullName AS CustomerName,
        hb.BranchName,
        b.CheckInDate,
        b.CheckOutDate,
        b.BookingStatus
    FROM Booking b
    JOIN Customer c
        ON b.CustomerID = c.CustomerID
    JOIN HotelBranch hb
        ON b.BranchID = hb.BranchID
    WHERE b.CustomerID = p_CustomerID;
END $$

DELIMITER ;


-- 4. PROCEDURE: Get bookings by branch ID
DROP PROCEDURE IF EXISTS GetBranchBookings;

DELIMITER $$

CREATE PROCEDURE GetBranchBookings(
    IN p_BranchID INT
)
BEGIN
    SELECT
        b.BookingID,
        c.FullName AS CustomerName,
        b.CheckInDate,
        b.CheckOutDate,
        b.BookingStatus
    FROM Booking b
    JOIN Customer c
        ON b.CustomerID = c.CustomerID
    WHERE b.BranchID = p_BranchID;
END $$

DELIMITER ;


-- TEST STORED PROCEDURES
CALL GetCustomerBookings(1);

CALL GetBranchBookings(1);

-- 5. TRIGGER: Validate room allocation
DROP TRIGGER IF EXISTS ValidateRoomAllocation;

DELIMITER $$

CREATE TRIGGER ValidateRoomAllocation
BEFORE INSERT ON BookingRoom
FOR EACH ROW
BEGIN
    DECLARE v_booking_branch INT;
    DECLARE v_room_branch INT;
    DECLARE v_checkin DATE;
    DECLARE v_checkout DATE;
    DECLARE v_booking_status VARCHAR(20);
    DECLARE v_room_status VARCHAR(20);
    DECLARE v_conflicts INT DEFAULT 0;

    -- Get booking details
    SELECT BranchID, CheckInDate, CheckOutDate, BookingStatus
    INTO v_booking_branch, v_checkin, v_checkout, v_booking_status
    FROM Booking
    WHERE BookingID = NEW.BookingID;

    -- Get room details
    SELECT BranchID, RoomStatus
    INTO v_room_branch, v_room_status
    FROM Room
    WHERE RoomID = NEW.RoomID;

    -- Check whether room belongs to the same branch
    IF v_booking_branch <> v_room_branch THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Room does not belong to the booking branch';
    END IF;

    -- Check room status
    IF v_room_status <> 'ACTIVE' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Room is not active';
    END IF;

    -- Check overlapping bookings
    IF v_booking_status IN ('PENDING', 'CONFIRMED') THEN

        SELECT COUNT(*)
        INTO v_conflicts
        FROM BookingRoom br
        JOIN Booking b ON br.BookingID = b.BookingID
        WHERE br.RoomID = NEW.RoomID
        AND b.BookingStatus IN ('PENDING', 'CONFIRMED')
        AND b.CheckInDate < v_checkout
        AND b.CheckOutDate > v_checkin;

        IF v_conflicts > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Room is already booked for these dates';
        END IF;

    END IF;

END $$

DELIMITER ;

-- Verify trigger
SHOW TRIGGERS;

-- 6. TRIGGER: Validate payment amount
DROP TRIGGER IF EXISTS ValidatePayment;

DELIMITER $$

CREATE TRIGGER ValidatePayment
BEFORE INSERT ON Payment
FOR EACH ROW
BEGIN
    IF NEW.Amount <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Payment amount must be greater than zero';
    END IF;
END $$

DELIMITER ;

-- Verify triggers
SHOW TRIGGERS;
