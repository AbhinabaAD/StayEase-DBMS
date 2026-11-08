
USE StayEase;

-- 1. Display all customers
SELECT * FROM Customer;

-- 2. Display all hotels
SELECT * FROM Hotel;

-- 3. Display customers from a specific name
SELECT * FROM Customer
WHERE FullName = 'Rahul Sharma';

-- 4. Display bookings with CONFIRMED status
SELECT * FROM Booking
WHERE BookingStatus = 'CONFIRMED';

-- 5. Display rooms that are currently ACTIVE
SELECT * FROM Room
WHERE RoomStatus = 'ACTIVE';

-- 6. Display customers in alphabetical order
SELECT * FROM Customer
ORDER BY FullName ASC;

-- 7. Display customers in reverse alphabetical order
SELECT * FROM Customer
ORDER BY FullName DESC;

-- 8. Display rooms sorted by room number
SELECT * FROM Room
ORDER BY RoomNumber ASC;

-- 9. Display bookings from newest to oldest
SELECT * FROM Booking
ORDER BY BookingDate DESC;

-- 10. Display payments from highest to lowest amount
SELECT * FROM Payment
ORDER BY Amount DESC;

-- 11. Display all unique booking statuses
SELECT DISTINCT BookingStatus
FROM Booking;

-- 12. Display all unique cities where hotel branches exist
SELECT DISTINCT City
FROM HotelBranch;

-- 13. Find customers whose names start with 'A'
SELECT * FROM Customer
WHERE FullName LIKE 'A%';

-- 14. Find customers whose names contain 'a'
SELECT * FROM Customer
WHERE FullName LIKE '%a%';

-- 15. Find rooms with room numbers between 101 and 201
SELECT * FROM Room
WHERE RoomNumber BETWEEN '101' AND '201';

-- 16. Find payments between ₹5,000 and ₹10,000
SELECT * FROM Payment
WHERE Amount BETWEEN 5000 AND 10000;

-- 17. Count total customers
SELECT COUNT(*) AS TotalCustomers
FROM Customer;

-- 18. Count total bookings
SELECT COUNT(*) AS TotalBookings
FROM Booking;

-- 19. Calculate total successful payments
SELECT SUM(Amount) AS TotalRevenue
FROM Payment
WHERE PaymentStatus = 'SUCCESS';

-- 20. Calculate average room rate
SELECT AVG(AgreedRatePerNight) AS AverageRoomRate
FROM BookingRoom;

-- 21. Find the highest payment
SELECT MAX(Amount) AS HighestPayment
FROM Payment;

-- 22. Find the lowest payment
SELECT MIN(Amount) AS LowestPayment
FROM Payment;

-- 23. Count bookings made by each customer
SELECT CustomerID, COUNT(*) AS TotalBookings
FROM Booking
GROUP BY CustomerID;

-- 24. Count rooms available in each branch
SELECT BranchID, COUNT(*) AS TotalRooms
FROM Room
WHERE RoomStatus = 'ACTIVE'
GROUP BY BranchID;

-- 25. Calculate total successful payment amount for each booking
SELECT BookingID, SUM(Amount) AS TotalPaid
FROM Payment
WHERE PaymentStatus = 'SUCCESS'
GROUP BY BookingID;

-- 26. Find average room rate for each booking
SELECT BookingID, AVG(AgreedRatePerNight) AS AverageRate
FROM BookingRoom
GROUP BY BookingID;

-- 27. Find customers who have made more than one booking
SELECT CustomerID, COUNT(*) AS TotalBookings
FROM Booking
GROUP BY CustomerID
HAVING COUNT(*) > 1;

-- 28. Find branches with more than two active rooms
SELECT BranchID, COUNT(*) AS ActiveRooms
FROM Room
WHERE RoomStatus = 'ACTIVE'
GROUP BY BranchID
HAVING COUNT(*) > 2;

-- 29. Display customer names with their booking details
SELECT
    c.CustomerID,
    c.FullName,
    b.BookingID,
    b.CheckInDate,
    b.CheckOutDate,
    b.BookingStatus
FROM Customer c
INNER JOIN Booking b
ON c.CustomerID = b.CustomerID;

-- 30. Display hotel names with their branches
SELECT
    h.HotelName,
    hb.BranchName,
    hb.City
FROM Hotel h
INNER JOIN HotelBranch hb
ON h.HotelID = hb.HotelID;

-- 31. Display booking details with customer names and hotel branches
SELECT
    b.BookingID,
    c.FullName,
    hb.BranchName,
    b.BookingStatus
FROM Booking b
INNER JOIN Customer c
ON b.CustomerID = c.CustomerID
INNER JOIN HotelBranch hb
ON b.BranchID = hb.BranchID;

-- 32. Display booking IDs with their allocated rooms
SELECT
    b.BookingID,
    r.RoomNumber,
    br.AgreedRatePerNight
FROM Booking b
INNER JOIN BookingRoom br
ON b.BookingID = br.BookingID
INNER JOIN Room r
ON br.RoomID = r.RoomID;

-- 33. Display all customers, including those without bookings
SELECT
    c.CustomerID,
    c.FullName,
    b.BookingID
FROM Customer c
LEFT JOIN Booking b
ON c.CustomerID = b.CustomerID;

-- 34. Display all hotels, including those without branches
SELECT
    h.HotelName,
    hb.BranchName
FROM Hotel h
LEFT JOIN HotelBranch hb
ON h.HotelID = hb.HotelID;

-- 35. RIGHT JOIN: Display all branches and their hotel names
SELECT
    h.HotelName,
    hb.BranchName,
    hb.City
FROM HotelBranch hb
RIGHT JOIN Hotel h
ON hb.HotelID = h.HotelID;

-- 36. Display customer names, booking details and payment information
SELECT
    c.FullName,
    b.BookingID,
    p.Amount,
    p.PaymentStatus
FROM Customer c
INNER JOIN Booking b
ON c.CustomerID = b.CustomerID
INNER JOIN Payment p
ON b.BookingID = p.BookingID;

-- 37. Display booking details with services used
SELECT
    b.BookingID,
    s.ServiceName,
    bs.Quantity,
    bs.UnitPrice
FROM Booking b
INNER JOIN BookingService bs
ON b.BookingID = bs.BookingID
INNER JOIN Service s
ON bs.ServiceID = s.ServiceID;

-- 38. Display customer reviews with customer names
SELECT
    c.FullName,
    b.BookingID,
    r.Rating,
    r.Comments
FROM Review r
INNER JOIN Booking b
ON r.BookingID = b.BookingID
INNER JOIN Customer c
ON b.CustomerID = c.CustomerID;

-- 39. Display all bookings and their payment information,
-- including bookings without payments
SELECT
    b.BookingID,
    b.BookingStatus,
    p.Amount,
    p.PaymentStatus
FROM Booking b
LEFT JOIN Payment p
ON b.BookingID = p.BookingID;

-- 40. Find customers who have made at least one booking
SELECT *
FROM Customer
WHERE CustomerID IN (
    SELECT CustomerID
    FROM Booking
);

-- 41. Find bookings with payments greater than average payment
SELECT *
FROM Booking
WHERE BookingID IN (
    SELECT BookingID
    FROM Payment
    WHERE Amount > (
        SELECT AVG(Amount)
        FROM Payment
    )
);

-- 42. Find rooms with rates above the average room rate
SELECT *
FROM BookingRoom
WHERE AgreedRatePerNight > (
    SELECT AVG(AgreedRatePerNight)
    FROM BookingRoom
);

-- 43. Find customers who have not made any bookings
SELECT *
FROM Customer c
WHERE NOT EXISTS (
    SELECT 1
    FROM Booking b
    WHERE b.CustomerID = c.CustomerID
);
