create database shophandmade;
use shophandmade;
CREATE TABLE Nguoidung(
    Ma INT PRIMARY KEY AUTO_INCREMENT,
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
    Trangthai TINYINT(1) DEFAULT 1,
    FOREIGN KEY (Ma_Vaitro) REFERENCES Vaitro (Ma)
);

CREATE TABLE Vaitro(
    Ma INT PRIMARY KEY,
    Ten VARCHAR(10) NOT NULL 
);



CREATE TABLE Danhmucsanpham(
    Ma INT PRIMARY KEY AUTO_INCREMENT,
    Ten varchar(30) NOT NULL DEFAULT '' 
);

CREATE TABLE Sanpham (
    Ma INT PRIMARY KEY AUTO_INCREMENT,
    Ten VARCHAR(30),
    Gia FLOAT NOT NULL CHECK (Gia >= 0),
    Hinhthunho VARCHAR(50) DEFAULT '',
    Mota LONGTEXT DEFAULT '',
    Ngaytao DATETIME,
    Ngaycapnhat DATETIME,
    Ma_Danhmucsanpham INT,
    FOREIGN KEY (Ma_Danhmucsanpham) REFERENCES Danhmucsanpham (Ma)
);
CREATE TABLE Danhgia (
    Ma INT PRIMARY KEY AUTO_INCREMENT,
    Ngaytao DATETIME,
    Sodiem TINYINT(5) ,
    Noidung LONGTEXT DEFAULT '',
    Ma_Sanpham INT,
    Ma_Nguoidung INT,
    FOREIGN KEY (Ma_Sanpham) REFERENCES Sanpham (Ma),
    FOREIGN KEY (Ma_Nguoidung) REFERENCES Nguoidung (Ma)
);
CREATE TABLE Donhang(
    Ma INT PRIMARY KEY AUTO_INCREMENT,
    Hoten_Nguoinhan VARCHAR(30) DEFAULT '',
    SDT_Nguoinhan VARCHAR(10) NOT NULL,
    Diachi_Nguoinhan VARCHAR(50) DEFAULT '',
    Emal_Nguoidung VARCHAR(30) DEFAULT '',
    Ngaydat DATETIME DEFAULT CURRENT_TIMESTAMP,
    Ngaygiaohang DATE,
    Ghichu VARCHAR(300) DEFAULT '',
    Phuongthucvanchuyen VARCHAR(30),
    Phuongthucthanhtoan VARCHAR(30),
    Sovandon VARCHAR(30) DEFAULT '',
    TrangthaiDH ENUM('Đang xử lý','Đang chuẩn bị','Đang vận chuyển','Đang giao hàng','Giao hàng thành công','Đơn hàng đã hủy'),
    Tongtien FLOAT CHECK(Tongtien >= 0),
    Trangthai TINYINT(1) DEFAULT 1,
    Ma_Nguoidung INT,
    FOREIGN KEY (Ma_Nguoidung) REFERENCES Nguoidung (Ma)
);


CREATE TABLE Chitietdonhang(
      
    Gia FLOAT CHECK(Gia >= 0),
    Soluong INT CHECK(Soluong > 0),
    Thanhtien FLOAT CHECK(Thanhtien >= 0),
    Ma_Donhang INT,
    Ma_Sanpham INT,
    FOREIGN KEY (Ma_Donhang) REFERENCES Donhang (Ma),
    FOREIGN KEY (Ma_Sanpham) REFERENCES Sanpham (Ma)
   
);
