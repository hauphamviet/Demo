-- Tạo cơ sở dữ liệu
CREATE DATABASE shophandmade;

-- Sử dụng cơ sở dữ liệu vừa tạo
USE shophandmade;

-- Tạo bảng Vaitro
CREATE TABLE Vaitro (
    Ma INT PRIMARY KEY,
    Ten VARCHAR(10) NOT NULL
);

-- Tạo bảng Nguoidung
CREATE TABLE Nguoidung (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Tentaikhoan VARCHAR(30) DEFAULT '',
    Matkhau VARCHAR(30) NOT NULL DEFAULT '',
    Hoten VARCHAR(30) DEFAULT '',
    Ngaysinh DATE,
    Ma_Vaitro INT,
    SDT VARCHAR(10) NOT NULL,
    Email VARCHAR(30) DEFAULT '',
    Diachi VARCHAR(50) DEFAULT '',
    Ngaytao DATETIME,
    Ngaycapnhat DATETIME,
    Trangthai TINYINT DEFAULT 1,
    FOREIGN KEY (Ma_Vaitro) REFERENCES Vaitro (Ma)
);

-- Tạo bảng Danhmucsanpham
CREATE TABLE Danhmucsanpham (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Ten VARCHAR(30) NOT NULL DEFAULT ''
);

-- Tạo bảng Sanpham
CREATE TABLE Sanpham (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Ten VARCHAR(30),
    Gia FLOAT NOT NULL CHECK (Gia >= 0),
    Hinhthunho VARCHAR(50) DEFAULT '',
    Mota TEXT DEFAULT '',  -- TEXT thay cho LONGTEXT
    Ngaytao DATETIME,
    Ngaycapnhat DATETIME,
    Ma_Danhmucsanpham INT,
    FOREIGN KEY (Ma_Danhmucsanpham) REFERENCES Danhmucsanpham (Ma)
);

-- Tạo bảng Danhgia
CREATE TABLE Danhgia (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Ngaytao DATETIME,
    Sodiem TINYINT,
    Noidung TEXT DEFAULT '',  -- TEXT thay cho LONGTEXT
    Ma_Sanpham INT,
    Ma_Nguoidung INT,
    FOREIGN KEY (Ma_Sanpham) REFERENCES Sanpham (Ma),
    FOREIGN KEY (Ma_Nguoidung) REFERENCES Nguoidung (Ma)
);

-- Tạo bảng Donhang
CREATE TABLE Donhang (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Hoten_Nguoinhan VARCHAR(30) DEFAULT '',
    SDT_Nguoinhan VARCHAR(10) NOT NULL,
    Diachi_Nguoinhan VARCHAR(50) DEFAULT '',
    Emal_Nguoidung VARCHAR(30) DEFAULT '',
    Ngaydat DATETIME DEFAULT GETDATE(),  -- GETDATE() thay cho CURRENT_TIMESTAMP
    Ngaygiaohang DATE,
    Ghichu VARCHAR(300) DEFAULT '',
    Phuongthucvanchuyen VARCHAR(30),
    Phuongthucthanhtoan VARCHAR(30),
    Sovandon VARCHAR(30) DEFAULT '',
    TrangthaiDH VARCHAR(20) CHECK(TrangthaiDH IN ('Đang xử lý','Đang chuẩn bị','Đang vận chuyển','Đang giao hàng','Giao hàng thành công','Đơn hàng đã hủy')),
    Tongtien FLOAT CHECK(Tongtien >= 0),
    Trangthai TINYINT DEFAULT 1,
    Ma_Nguoidung INT,
    FOREIGN KEY (Ma_Nguoidung) REFERENCES Nguoidung (Ma)
);

-- Tạo bảng Chitietdonhang
CREATE TABLE Chitietdonhang (
    Gia FLOAT CHECK(Gia >= 0),
    Soluong INT CHECK(Soluong > 0),
    Thanhtien FLOAT CHECK(Thanhtien >= 0),
    Ma_Donhang INT,
    Ma_Sanpham INT,
    FOREIGN KEY (Ma_Donhang) REFERENCES Donhang (Ma),
    FOREIGN KEY (Ma_Sanpham) REFERENCES Sanpham (Ma)
);
