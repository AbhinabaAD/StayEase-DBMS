
USE StayEase;

-- 1. HOTELS
INSERT INTO Hotel (HotelName, Description) VALUES
('Grand Stay Hotels', 'Premium hotels offering luxury accommodation'),
('Comfort Inn Group', 'Affordable and comfortable stays');

-- 2. CUSTOMERS
-- Sample password hashes are placeholders, not usable login credentials.
INSERT INTO Customer (FullName, Email, Phone, PasswordHash) VALUES
('Rahul Sharma', 'rahul@example.com', '9876543210', 'sample_hash_001'),
('Priya Nair', 'priya@example.com', '9876543211', 'sample_hash_002'),
('Arjun Mehta', 'arjun@example.com', '9876543212', 'sample_hash_003'),
('Sneha Rao', 'sneha@example.com', '9876543213', 'sample_hash_004'),
('Karan Das', 'karan@example.com', '9876543214', 'sample_hash_005');

-- 3. ROOM TYPES
INSERT INTO RoomType (TypeName, Capacity, Description) VALUES
('Standard', 2, 'Comfortable standard room'),
('Deluxe', 3, 'Spacious deluxe room'),
('Suite', 4, 'Premium suite with living area'),
('Family', 5, 'Large room suitable for families');

-- Verify inserted records
SELECT * FROM Hotel;
SELECT * FROM Customer;
SELECT * FROM RoomType;

-- 4. HOTEL BRANCHES
INSERT INTO HotelBranch
(HotelID, BranchName, Address, City, State, Pincode, Country, Phone)
VALUES
(1, 'Grand Stay MG Road', '12 MG Road', 'Bengaluru', 'Karnataka', '560001', 'India', '08040001001'),
(1, 'Grand Stay Whitefield', '45 ITPL Road', 'Bengaluru', 'Karnataka', '560066', 'India', '08040001002'),
(2, 'Comfort Inn Koramangala', '78 5th Block', 'Bengaluru', 'Karnataka', '560095', 'India', '08040002001');

-- 5. ROOMS
INSERT INTO Room
(BranchID, RoomNumber, RoomTypeID, Floor, RoomStatus)
VALUES
(1, '101', 1, 1, 'ACTIVE'),
(1, '102', 2, 1, 'ACTIVE'),
(1, '201', 3, 2, 'ACTIVE'),
(1, '202', 4, 2, 'ACTIVE'),
(2, '101', 1, 1, 'ACTIVE'),
(2, '102', 2, 1, 'ACTIVE'),
(2, '201', 3, 2, 'ACTIVE'),
(3, '101', 1, 1, 'ACTIVE'),
(3, '102', 2, 1, 'ACTIVE');

-- 6. EMPLOYEES
INSERT INTO Employee
(BranchID, FullName, Email, Phone, Designation, HireDate)
VALUES
(1, 'Amit Kumar', 'amit@grandstay.com', '9876500001', 'Manager', '2024-01-15'),
(1, 'Neha Singh', 'neha@grandstay.com', '9876500002', 'Receptionist', '2024-03-10'),
(2, 'Rohan Das', 'rohan@grandstay.com', '9876500003', 'Manager', '2024-02-20'),
(3, 'Ananya Roy', 'ananya@comfortinn.com', '9876500004', 'Manager', '2024-04-05');

-- Verify
SELECT * FROM HotelBranch;
SELECT * FROM Room;
SELECT * FROM Employee;

-- 7. SERVICES
INSERT INTO Service
(BranchID, ServiceName, Description, ServicePrice)
VALUES
(1, 'Breakfast', 'Complimentary-style buffet breakfast', 350.00),
(1, 'Laundry', 'Laundry and ironing service', 200.00),
(1, 'Airport Pickup', 'Airport pickup service', 800.00),
(2, 'Breakfast', 'Daily buffet breakfast', 300.00),
(2, 'Spa', 'Relaxation and wellness service', 1200.00),
(3, 'Breakfast', 'Continental breakfast', 250.00),
(3, 'Laundry', 'Laundry service', 180.00);

-- VERIFY
SELECT * FROM Service;

-- 8. BOOKINGS
INSERT INTO Booking
(CustomerID, BranchID, CheckInDate, CheckOutDate, BookingStatus)
VALUES
(1, 1, '2026-12-01', '2026-12-04', 'CONFIRMED'),
(2, 1, '2026-12-05', '2026-12-08', 'CONFIRMED'),
(3, 2, '2026-12-10', '2026-12-13', 'CONFIRMED'),
(4, 3, '2026-12-15', '2026-12-18', 'PENDING'),
(5, 2, '2026-12-20', '2026-12-23', 'CONFIRMED');

-- VERIFY BOOKINGS
SELECT * FROM Booking;

-- 9. BOOKING ROOM ALLOCATIONS
INSERT INTO BookingRoom
(BookingID, RoomID, AgreedRatePerNight)
VALUES
(1, 1, 2500.00),
(2, 2, 3500.00),
(3, 5, 2500.00),
(4, 8, 2200.00),
(5, 6, 3500.00);

-- VERIFY
SELECT * FROM BookingRoom;

-- 10. PAYMENTS
INSERT INTO Payment
(BookingID, Amount, PaymentMethod, PaymentStatus, TransactionReference)
VALUES
(1, 7500.00, 'UPI', 'SUCCESS', 'TXN_STAY_001'),
(2, 10500.00, 'CARD', 'SUCCESS', 'TXN_STAY_002'),
(3, 7500.00, 'UPI', 'SUCCESS', 'TXN_STAY_003'),
(4, 4000.00, 'CASH', 'PENDING', 'TXN_STAY_004'),
(5, 10500.00, 'NET_BANKING', 'SUCCESS', 'TXN_STAY_005');

-- VERIFY
SELECT * FROM Payment;

-- 11. BOOKING SERVICES
INSERT INTO BookingService
(BookingID, ServiceID, ServiceDate, Quantity, UnitPrice)
VALUES
(1, 1, '2026-12-02', 2, 350.00),
(1, 2, '2026-12-03', 1, 200.00),
(2, 3, '2026-12-05', 1, 800.00),
(3, 4, '2026-12-11', 2, 300.00),
(3, 5, '2026-12-12', 1, 1200.00),
(4, 6, '2026-12-16', 2, 250.00),
(5, 4, '2026-12-21', 2, 300.00);

-- VERIFY
SELECT * FROM BookingService;

-- 12. HISTORICAL COMPLETED BOOKING
INSERT INTO Booking
(CustomerID, BranchID, CheckInDate, CheckOutDate, BookingStatus)
VALUES
(1, 1, '2026-10-01', '2026-10-04', 'COMPLETED');

-- 13. ROOM ALLOCATION FOR HISTORICAL BOOKING
INSERT INTO BookingRoom
(BookingID, RoomID, AgreedRatePerNight)
VALUES
(6, 3, 4500.00);

-- 14. PAYMENT FOR HISTORICAL BOOKING
INSERT INTO Payment
(BookingID, Amount, PaymentMethod, PaymentStatus, TransactionReference)
VALUES
(6, 13500.00, 'UPI', 'SUCCESS', 'TXN_STAY_006');
