USE StayEase;

-- 1. CUSTOMER
CREATE TABLE IF NOT EXISTS Customer (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL,
    Email VARCHAR(150) NOT NULL UNIQUE,
    Phone VARCHAR(20),
    PasswordHash VARCHAR(255) NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;


-- 2. HOTEL
CREATE TABLE IF NOT EXISTS Hotel (
    HotelID INT AUTO_INCREMENT PRIMARY KEY,
    HotelName VARCHAR(150) NOT NULL,
    Description TEXT
) ENGINE=InnoDB;


-- 3. HOTEL BRANCH
CREATE TABLE IF NOT EXISTS HotelBranch (
    BranchID INT AUTO_INCREMENT PRIMARY KEY,
    HotelID INT NOT NULL,
    BranchName VARCHAR(150) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    City VARCHAR(100) NOT NULL,
    State VARCHAR(100),
    Pincode VARCHAR(15),
    Country VARCHAR(100) NOT NULL,
    Phone VARCHAR(20),

    CONSTRAINT fk_branch_hotel
        FOREIGN KEY (HotelID)
        REFERENCES Hotel(HotelID)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
) ENGINE=InnoDB;


-- 4. ROOM TYPE
CREATE TABLE IF NOT EXISTS RoomType (
    RoomTypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName VARCHAR(50) NOT NULL UNIQUE,
    Capacity INT NOT NULL,
    Description TEXT,

    CHECK (Capacity > 0)
) ENGINE=InnoDB;


-- 5. ROOM
CREATE TABLE IF NOT EXISTS Room (
    RoomID INT AUTO_INCREMENT PRIMARY KEY,
    BranchID INT NOT NULL,
    RoomNumber VARCHAR(20) NOT NULL,
    RoomTypeID INT NOT NULL,
    Floor INT,
    RoomStatus VARCHAR(20) DEFAULT 'ACTIVE',

    UNIQUE (BranchID, RoomNumber),

    CHECK (RoomStatus IN (
        'ACTIVE', 'MAINTENANCE', 'INACTIVE'
    )),

    FOREIGN KEY (BranchID)
        REFERENCES HotelBranch(BranchID),

    FOREIGN KEY (RoomTypeID)
        REFERENCES RoomType(RoomTypeID)
) ENGINE=InnoDB;


-- 6. BOOKING
CREATE TABLE IF NOT EXISTS Booking (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    BranchID INT NOT NULL,
    BookingDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    CheckInDate DATE NOT NULL,
    CheckOutDate DATE NOT NULL,
    BookingStatus VARCHAR(20) DEFAULT 'PENDING',

    CHECK (CheckOutDate > CheckInDate),

    CHECK (BookingStatus IN (
        'PENDING', 'CONFIRMED',
        'CANCELLED', 'COMPLETED'
    )),

    FOREIGN KEY (CustomerID)
        REFERENCES Customer(CustomerID),

    FOREIGN KEY (BranchID)
        REFERENCES HotelBranch(BranchID)
) ENGINE=InnoDB;


-- 7. BOOKING ROOM
CREATE TABLE IF NOT EXISTS BookingRoom (
    BookingID INT NOT NULL,
    RoomID INT NOT NULL,
    AgreedRatePerNight DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (BookingID, RoomID),

    CHECK (AgreedRatePerNight >= 0),

    FOREIGN KEY (BookingID)
        REFERENCES Booking(BookingID),

    FOREIGN KEY (RoomID)
        REFERENCES Room(RoomID)
) ENGINE=InnoDB;


-- 8. PAYMENT
CREATE TABLE IF NOT EXISTS Payment (
    PaymentID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT NOT NULL,
    PaymentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Amount DECIMAL(12,2) NOT NULL,
    PaymentMethod VARCHAR(30) NOT NULL,
    PaymentStatus VARCHAR(20) DEFAULT 'PENDING',
    TransactionReference VARCHAR(100) UNIQUE,

    CHECK (Amount > 0),

    CHECK (PaymentMethod IN (
        'CASH', 'CARD', 'UPI', 'NET_BANKING'
    )),

    CHECK (PaymentStatus IN (
        'PENDING', 'SUCCESS',
        'FAILED', 'REFUNDED'
    )),

    FOREIGN KEY (BookingID)
        REFERENCES Booking(BookingID)
) ENGINE=InnoDB;


-- 9. EMPLOYEE
CREATE TABLE IF NOT EXISTS Employee (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    BranchID INT NOT NULL,
    FullName VARCHAR(100) NOT NULL,
    Email VARCHAR(150) NOT NULL UNIQUE,
    Phone VARCHAR(20),
    Designation VARCHAR(60),
    HireDate DATE,

    FOREIGN KEY (BranchID)
        REFERENCES HotelBranch(BranchID)
) ENGINE=InnoDB;


-- 10. SERVICE
CREATE TABLE IF NOT EXISTS Service (
    ServiceID INT AUTO_INCREMENT PRIMARY KEY,
    BranchID INT NOT NULL,
    ServiceName VARCHAR(100) NOT NULL,
    Description TEXT,
    ServicePrice DECIMAL(10,2) NOT NULL,

    UNIQUE (BranchID, ServiceName),

    CHECK (ServicePrice >= 0),

    FOREIGN KEY (BranchID)
        REFERENCES HotelBranch(BranchID)
) ENGINE=InnoDB;


-- 11. BOOKING SERVICE
CREATE TABLE IF NOT EXISTS BookingService (
    BookingServiceID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT NOT NULL,
    ServiceID INT NOT NULL,
    ServiceDate DATE NOT NULL,
    Quantity INT NOT NULL DEFAULT 1,
    UnitPrice DECIMAL(10,2) NOT NULL,

    CHECK (Quantity > 0),
    CHECK (UnitPrice >= 0),

    FOREIGN KEY (BookingID)
        REFERENCES Booking(BookingID),

    FOREIGN KEY (ServiceID)
        REFERENCES Service(ServiceID)
) ENGINE=InnoDB;


-- 12. REVIEW
CREATE TABLE IF NOT EXISTS Review (
    ReviewID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT NOT NULL UNIQUE,
    Rating INT NOT NULL,
    Comments TEXT,
    ReviewDate DATETIME DEFAULT CURRENT_TIMESTAMP,

    CHECK (Rating BETWEEN 1 AND 5),

    FOREIGN KEY (BookingID)
        REFERENCES Booking(BookingID)
) ENGINE=InnoDB;


-- ADDITIONAL INDEXES
CREATE INDEX idx_booking_customer
ON Booking(CustomerID);

CREATE INDEX idx_booking_branch
ON Booking(BranchID);

CREATE INDEX idx_booking_dates
ON Booking(CheckInDate, CheckOutDate);

CREATE INDEX idx_payment_booking
ON Payment(BookingID);

CREATE INDEX idx_booking_service
ON BookingService(BookingID);
