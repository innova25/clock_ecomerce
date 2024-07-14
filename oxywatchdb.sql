
create database oxywatchdb
go
use oxywatchdb
go
create table [account](
[id] [int] identity(1,1) primary key not null,
[username]  [nvarchar](50) NULL,
[password] [nvarchar](50) NULL,
[realname] [nvarchar](50) null,
[phone]  [nvarchar](50) NULL,
[email]  [nvarchar](100) NULL,
[address]  [nvarchar](500) NULL,
[role] [nvarchar](50),
[avatar] [nvarchar](max) NULL
)
go
create table [staff](
[id] [int] identity(1,1) primary key not null,
[name] [nvarchar](50) null,
[phone]  [nvarchar](50) NULL,
[email]  [nvarchar](100) NULL
)
go
create table [order](
[id] [int] identity(1,1) primary key not null,
[total] [money] ,
[address] [nvarchar](500),
[orderdate] [date] ,
[orderdelivery] [date] ,
[accountid] [int] foreign key references [account]([id]),
[staffid] [int] foreign key references [staff]([id])
)
go
create table [category](
[id] [int] identity(1,1) primary key not null,
[name] [nvarchar](250) null
)
go
create table [typeproduct](
[id] [int] primary key not null,
[name] [nvarchar](250) null,
[categoryid] [int] foreign key references [category]([id])
)
go
create table [product](
[id] [int] identity(1,1) primary key not null,
[name] [nvarchar](250) ,
[describe] [nvarchar](500) null,
[price] [int] ,
[dispercent] [int] ,
[dateupdate] [date] null,
[status] [nvarchar](250) null,
[source] [nvarchar](250) null,
[guarantee] [nvarchar](250) null,
[shell] [nvarchar](250) null,
[glasses] [nvarchar](250) null,
[energy] [nvarchar](250) null,
[waterproof] [nvarchar](250) null,
[facesize] [int] null,
[wiresize] [int] null,
[checkgoods] [nvarchar](250) null,
[advise] [nvarchar](250) null,
[idtypeproduct] [int] foreign key references [typeproduct]([id])
)
go
create table [orderdetail](
[id] [int] identity(1,1) primary key not null,
[quantity] [int] ,
[price] [money],
[total] [money],
[note] [nvarchar](100) NULL,
[orderid] [int] foreign key references [order]([id]),
[productid] [int] foreign key references [product]([id])
)
go
create table [payments](
	[paymentid] [int] identity(1,1) primary key not null,
	[amount] [money] ,
	[paymentmethod] [nvarchar](100) null,
	[paymentdate] [date] null,
    [idorderdetail]  [int] foreign key references [orderdetail]([id]),
	[idaccount] [int] foreign key references [account]([id])
)
go
create table [reviews](
	[reviewid] [int] identity(1,1) primary key not null,
	[content] [nvarchar](100) null,
	[rate] [int] null,
	[review_date] [date] null,
	[idaccount] [int] foreign key references [account]([id]),
	[productid] [int] foreign key references [product]([id])
)
go
create table [images](
[id] [int] identity(1,1) primary key not null,
[link] [nvarchar](250) ,
[productid] [int] foreign key references [product]([id])
)
go
create table [stock](
    [productid] [int] identity(1,1) primary key not null,
    [quantity] [int] not null,
    foreign key ([productid]) references [product]([id])
)

/*-----------------------------------------------------------------*/
go
insert into [account]([username],[password],[realname],[address],[email],[phone],[avatar],[role])
values  ( 'user1' , 'pass1' , 'name1' , 'address1' , 'email1' , '0987654321' , 'a1.jpg' , N'admin'),
		( 'user2' , 'pass2' , 'name2' , 'address2' , 'email2' , '0987654322' , 'a1.jpg' , N'admin'),
		( 'user3' , 'pass3' , 'name3' , 'address3' , 'email3' , '0987654323' , 'a1.jpg' , N'admin'),
		( 'user4' , 'pass4' , 'name4' , 'address4' , 'email4' , '0987654324' , 'u1.jpg' , N'client'),
		( 'user5' , 'pass5' , 'name5' , 'address5' , 'email5' , '0987654325' , 'u1.jpg' , N'client'),
		( 'user6' , 'pass6' , 'name6' , 'address6' , 'email6' , '0987654326' , 'u1.jpg' , N'client'),
		( 'user7' , 'pass7' , 'name7' , 'address7' , 'email7' , '0987654327' , 'u1.jpg' , N'client'),
		( 'user8' , 'pass8' , 'name8' , 'address8' , 'email8' , '0987654328' , 'u1.jpg' , N'client'),
		( 'user9' , 'pass9' , 'name9' , 'address9' , 'email9' , '0987654328' , 'u1.jpg' , N'client'),
		( 'user10' , 'pass10' , 'name10' , 'address10' , 'email10' , '0987654331' , 'u1.jpg' , N'client')
/*-----------------------------------------------------------------*/
go
insert into [staff]([name],[phone],[email])
values  ('staff1','0912345678','email1'),
		('staff2','0912345677','email2'),
		('staff3','0912345676','email3'),
		('staff4','0912345675','email4'),
		('staff5','0912345674','email5')
/*-----------------------------------------------------------------*/
go
insert into [category]([name])
values  ( N'ĐỒNG HỒ NAM'),
		( N'ĐỒNG HỒ NỮ')
/*-----------------------------------------------------------------*/
go
insert into [typeproduct]( [id],[categoryid],[name])
values  ( 1 , 1 , N'Đồng Hồ Tevise'),
		( 2 , 1 , N'Đồng Hồ Skmei'),
		( 3 , 1 , N'Đồng Hồ Halei'),
		( 4 , 1 , N'Đồng Hồ Baishuns'),
		( 5 , 1 , N'Đồng Hồ Longbo'),
		( 6 , 1 , N'Đồng Hồ Curren'),
		( 7 , 2 , N'Đồng Hồ Beesister'),
		( 8 , 2 , N'Đồng Hồ Skmei'),
		( 9 , 2 , N'Đồng Hồ Halei')
/*-----------------------------------------------------------------*/
go
insert into [product]( [name] , [describe] , [price] ,[dispercent], [dateupdate], [idtypeproduct] , [status] , [source] , [guarantee] , [shell],[glasses],[energy],[waterproof],[facesize],[wiresize],[checkgoods],[advise])
values  (  N'ĐỒNG HỒ LONGBO MẶT VUÔNG MÀU ĐEN' ,N'ĐỒNG HỒ LONGBO MẶT VUÔNG MÀU ĐEN' , 500000 , 40 , '2023-01-01' , 5 ,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ LONGBO MẶT VUÔNG MÀU TRẮNG' ,N'ĐỒNG HỒ LONGBO MẶT VUÔNG MÀU TRẮNG' , 500000 , 42 , '2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY DA CỰC CHẤT' ,N'ĐỒNG HỒ NAM LONGBO DÂY DA CỰC CHẤT' , 500000 , 0 ,  '2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NAM LONGBO DÂY DA CỰC CHẤT MẪU DH02' ,N'ĐỒNG HỒ NAM LONGBO DÂY DA CỰC CHẤT MẪU DH02' , 500000 , 20 , '2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH03' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH03' , 500000 , 20 , '2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH04' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH04' , 500000 , 20 , '2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH05' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH05' , 540000 , 20 ,'2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH07' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH07' , 540000 , 20 ,'2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH08' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH08' , 540000 , 20 ,'2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH09' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH09' , 600000 , 20 ,'2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH10' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH10' , 800000 ,20 , '2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH11' ,N'ĐỒNG HỒ NAM LONGBO DÂY KIM LOẠI CỰC CHẤT MẪU DH11' , 800000 , 20 ,'2023-01-01' , 5,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM SKMEI KIM XANH DƯƠNG' ,N'ĐỒNG HỒ NAM SKMEI KIM XANH DƯƠNG' , 500000 ,20 , '2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ ĐÔI SKMEI SK1815' ,N'ĐỒNG HỒ ĐÔI SKMEI SK1815' , 9900000 , 20 ,'2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ ĐÔI THỂ THAO SKMEI SK1811' ,N'ĐỒNG HỒ ĐÔI THỂ THAO SKMEI SK1811' , 990000 ,20 , '2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ ĐÔI THỂ THAO SKMEI SK1810' ,N'ĐỒNG HỒ ĐÔI THỂ THAO SKMEI SK1810' , 980000 ,20 , '2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ ĐÔI SKMEI 9120' ,N'ĐỒNG HỒ ĐÔI SKMEI 9120' , 580000 , 20 ,'2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM SKMEI 1181-1185' ,N'ĐỒNG HỒ NAM SKMEI 1181-1185' , 970000 ,20 , '2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM SKMEI 1245' ,N'ĐỒNG HỒ NAM SKMEI 1245' , 900000 ,20 , '2023-01-01' , 2,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ ĐIỆN TỬ NỮ SKMEI-SK1832' ,N'ĐỒNG HỒ NỮ ĐIỆN TỬ NỮ SKMEI-SK1832' , 450000 ,20 ,  '2023-01-01' , 8,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NỮ SKMEI SK1822' ,N'ĐỒNG HỒ NỮ SKMEI SK1822' , 500000 , 20 , '2023-01-01' , 8,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ SKMEI SK1824' ,N'ĐỒNG HỒ NỮ SKMEI SK1824' , 500000 , 20 , '2023-01-01' , 8,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ SKMEI SK1827' ,N'ĐỒNG HỒ NỮ SKMEI SK1827' , 500000 , 20 , '2023-01-01' , 8,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ SKMEI SK1828' ,N'ĐỒNG HỒ NỮ SKMEI SK1828' , 500000 , 20 , '2023-01-01' , 8,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ SKMEI SK18313' ,N'ĐỒNG HỒ NỮ SKMEI SK18313' , 550000 , 20 , '2023-01-01' , 8,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM TEVISE 1952 CHẠY CƠ CỰC CHẤT' ,N'ĐỒNG HỒ NAM TEVISE 1952 CHẠY CƠ CỰC CHẤT' , 500000 , 20 , '2023-01-01' , 1,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM TEVISE CHẠY CƠ MẶT CHẠM RỒNG CỰC SANG' ,N'ĐỒNG HỒ NAM TEVISE CHẠY CƠ MẶT CHẠM RỒNG CỰC SANG' , 500000 ,20  , '2023-01-01' , 1,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒTEVISE 8383V NAM MẶT VUÔNG DÂY DA MÁY CƠ' ,N'ĐỒNG HỒTEVISE 8383V NAM MẶT VUÔNG DÂY DA MÁY CƠ' , 12500000 ,20  , '2023-01-01' , 1,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ TEVISE MÁY CƠ AUTOMATIC DÂY DA CAO CẤP' ,N'ĐỒNG HỒ TEVISE MÁY CƠ AUTOMATIC DÂY DA CAO CẤP' , 550000 , 20 , '2023-01-01' , 1,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ TEVISE MÁY CƠ AUTOMATIC DÂY THÉP CAO CẤP' ,N'ĐỒNG HỒ TEVISE MÁY CƠ AUTOMATIC DÂY THÉP CAO CẤP' , 950000 ,20 ,  '2023-01-01' , 1,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ TEVISE MÁY CƠ AUTOMATIC DÂY THÉP DEMI GIÁ RẺ' ,N'ĐỒNG HỒ TEVISE MÁY CƠ AUTOMATIC DÂY THÉP DEMI GIÁ RẺ' , 950000 , 20 , '2023-01-01' , 1,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ HALEI CHÍNH HÃNG DÀNH CHO NAM' ,N'ĐỒNG HỒ HALEI CHÍNH HÃNG DÀNH CHO NAM' , 330000 , 20 , '2023-01-01' , 3,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM NỮ HALEI 502 CHÍNH HÃNG MẠ VÀNG' ,N'ĐỒNG HỒ NAM NỮ HALEI 502 CHÍNH HÃNG MẠ VÀNG' , 169000 ,20 ,  '2023-01-01' , 3,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NAM NỮ HALEI 502 CHÍNH HÃNG MẠ BẠC' ,N'ĐỒNG HỒ NAM NỮ HALEI 502 CHÍNH HÃNG MẠ BẠC' , 950000 ,20 ,  '2023-01-01' , 3,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM HALEI HL95 CHÍNH HÃNG MẶT VUÔNG CAO CẤP' ,N'ĐỒNG HỒ NAM HALEI HL95 CHÍNH HÃNG MẶT VUÔNG CAO CẤP' , 250000 ,20 ,  '2023-01-01' , 3,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ HALEI CHÍNH HÃNG' ,N'ĐỒNG HỒ NỮ HALEI CHÍNH HÃNG' , 330000 ,20 ,  '2023-01-01' , 9,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ HIỆU HALEI CHÍNH HÃNG' ,N'ĐỒNG HỒ NỮ HIỆU HALEI CHÍNH HÃNG' , 179000 ,20 ,  '2023-01-01' , 9,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(N'ĐỒNG HỒ HALEI NỮ CHÍNH HÃNG DÂY KIM LOẠI NHUYỄN' ,N'ĐỒNG HỒ HALEI NỮ CHÍNH HÃNG DÂY KIM LOẠI NHUYỄN' , 300000 ,20 ,  '2023-01-01' , 9,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NỮ HALEI MÁY NHẬT CHÍNH HÃNG MẶT SAPHIA' ,N'ĐỒNG HỒ NỮ HALEI MÁY NHẬT CHÍNH HÃNG MẶT SAPHIA' , 580000 , 20 , '2023-01-01' , 9,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NAM BAISHUNS DÂY VÀNG BSO333' ,N'ĐỒNG HỒ NAM BAISHUNS DÂY VÀNG BSO333' , 165000 ,20 ,  '2023-01-01' , 4,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NAM BAISHUNS 544 CHỐNG NƯỚC TUYỆT ĐỐI' ,N'ĐỒNG HỒ NAM BAISHUNS 544 CHỐNG NƯỚC TUYỆT ĐỐI' , 150000 , 20 , '2023-01-01' , 4,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NAM BAISHUNS' , N'ĐỒNG HỒ NAM BAISHUNS' , 199000 , 20 , '2023-01-01' , 4,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NAM BAISHUN DÂY VÀNG CHỐNG' ,N'ĐỒNG HỒ NAM BAISHUN DÂY VÀNG CHỐNG' , 250000 ,20 ,  '2023-01-01' , 4,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NAM CURREN CU03 CHÍNH HÃNG' ,N'ĐỒNG HỒ NAM CURREN CU03 CHÍNH HÃNG' , 368000 , 20 , '2023-01-01' , 6,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ CURREN M8329' ,N'ĐỒNG HỒ CURREN M8329' , 649000 , 20 , '2023-01-01' , 6,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ CURREN M8329' ,N'ĐỒNG HỒ CURREN M8329' , 649000 ,20 ,  '2023-01-01' , 6,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ DOANH NHÂN NAM DÂY DA M8380' , N'ĐỒNG HỒ DOANH NHÂN NAM DÂY DA M8380' , 534000 ,20 ,  '2023-01-01' , 6,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ BS BEE SISTER 0280 ĐÍNH ĐÁ' ,N'ĐỒNG HỒ NỮ BS BEE SISTER 0280 ĐÍNH ĐÁ' , 180000 ,20 ,  '2023-01-01' , 7,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		( N'ĐỒNG HỒ NỮ BS ROMATIC 8040 ĐÍNH ĐÁ' ,N'ĐỒNG HỒ NỮ BS ROMATIC 8040 ĐÍNH ĐÁ' , 175000 , 20 , '2023-01-01' , 7,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ BEE SISTER 1351 CHÍNH HÃNG' ,N'ĐỒNG HỒ NỮ BEE SISTER 1351 CHÍNH HÃNG' , 199000 , 20 , '2023-01-01' , 7,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888'),
		(  N'ĐỒNG HỒ NỮ BS BEE SISTER JAMIE ĐÍNH ĐÁ' ,N'ĐỒNG HỒ NỮ BS BEE SISTER JAMIE ĐÍNH ĐÁ' , 165000 , 20 , '2023-01-01' , 7,N'Mới',N'Hàng Công Ty',N'6 Tháng',N'Thép cao cấp không gỉ' ,N'Kính cao cấp chống xước',N'Chạy cơ',N'Tuyệt đối',40,22,N'Cho phép kiểm hàng ',N'0978.828.888')


/*-----------------------------------------------------------------*/
go
insert into [images]([productid],[link])
values  (  1 , N'lb1.jpg'),/*LONGBO NAM*/
		(  1 , N'lb1a.jpg'),
		(  2 , N'lb2.jpg'),
		(  2 , N'lb2a.jpg'),
		(  3 , N'lb3.jpg'),
		(  3 , N'lb3a.jpg'),
		(  4 , N'lb4.jpg'),
		( 4 , N'lb4a.jpg'),
		(  5 , N'lb5.jpg'),
		(  5 , N'lb5a.jpg'),
		(  6 , N'lb6.jpg'),
		(  6 , N'lb6a.jpg'),
		(  7 , N'lb7.jpg'),
		(  7 , N'lb7a.jpg'),
		(  8 , N'lb8.jpg'),
		(  8 , N'lb8a.jpg'),
		(  9 , N'lb9.jpg'),
		(  9 , N'lb9a.jpg'),
		(  10 , N'lb10.jpg'),
		(  10 , N'lb10a.jpg'),
		(  11 , N'lb11.jpg'),
		(  11 , N'lb11a.jpg'),
		(  12 , N'lb12.jpg'),
		(  12 , N'lb12a.jpg'),
		(  13 , N'sk7.jpg'),/*SKMEI NAM*/
		(  13 , N'sk7a.jpg'),
		(  14 , N'sk1.jpg'),
		(  14 , N'sk1a.jpg'),
		(  15 , N'sk2.jpg'),
		(  15 , N'sk2a.jpg'),
		(  16 , N'sk3.jpg'),
		(  16 , N'sk3a.jpg'),
		(  17 , N'sk4.jpg'),
		(  17 , N'sk4a.jpg'),
		(  18 , N'sk5.jpg'),
		(  18 , N'sk5a.jpg'),
		(  19 , N'sk6.jpg'),
		(  19 , N'sk6a.jpg'),
		(  20 , N'sk8.jpg'),/*SKMEI NỮ*/
		(  20 , N'sk8a.jpg'),
		(  21 , N'sk9.jpg'),
		(  21 , N'sk9a.jpg'),
		(  22 , N'sk10.jpg'),
		(  22 , N'sk10a.jpg'),
		(  23 , N'sk11.jpg'),
		(  23 , N'sk11a.jpg'),
		(  24 , N'sk12.jpg'),
		(  24 , N'sk12a.jpg'),
		(  25 , N'sk13.jpg'),
		(  25 , N'sk13a.jpg'),
		(  26 , N'te1.jpg'),/*TEVISE NAM*/
		(  26 , N'te1a.jpg'),
		(  27 , N'te2.jpg'),
		(  27 , N'te2a.jpg'),
		(  28 , N'te3.jpg'),
		(  28 , N'te3a.jpg'),
		(  29 , N'te4.jpg'),
		(  29 , N'te4a.jpg'),
		(  30 , N'te5.jpg'),
		(  30 , N'te5a.jpg'),
		(  31 , N'te6.jpg'),
		(  31 , N'te6a.jpg'),
		(  32 , N'ha1.jpg'),/*HALEI NAM*/
		(  32 , N'ha1a.jpg'),
		(  33 , N'ha2.jpg'),
		(  33 , N'ha2a.jpg'),
		(  34 , N'ha3.jpg'),
		(  34 , N'ha3a.jpg'),
		(  35 , N'ha4.jpg'),
		(  35 , N'ha4a.jpg'),
		(  36 , N'ha5.jpg'),/*HALEI NỮ*/
		(  36 , N'ha5a.jpg'),
		(  37 , N'ha6.jpg'),
		(  37 , N'ha6a.jpg'),
		(  38 , N'ha7.jpg'),
		(  38 , N'ha7a.jpg'),
		(  39 , N'ha8.jpg'),
		(  39 , N'ha8a.jpg'),
		(  40 , N'ba1.jpg'),/*BAISHUNS NAM*/
		(  40 , N'ba1a.jpg'),
		(  41 , N'ba2.jpg'),
		(  41 , N'ba2a.jpg'),
		(  42 , N'ba3.jpg'),
		(  42 , N'ba3a.jpg'),
		(  43 , N'ba4.jpg'),
		(  43 , N'ba4a.jpg'),
		(  44 , N'cu1.jpg'),/*CURREN NAM*/
		(  44 , N'cu1a.jpg'),
		(  45 , N'cu2.jpg'),
		(  45 , N'cu2a.jpg'),
		(  46 , N'cu3.jpg'),
		(  46 , N'cu3a.jpg'),
		(  47 , N'cu4.jpg'),
		(  47 , N'cu4a.jpg'),
		(  48 , N'be1.jpg'),/*BEESISTER NỮ*/
		(  48 , N'be1a.jpg'),
		(  49 , N'be2.jpg'),
		(  49 , N'be2a.jpg'),
		(  50 , N'be3.jpg'),
		(  50 , N'be3a.jpg'),
		(  51 , N'be4.jpg'),
		(  51 , N'be4a.jpg')
/*-----------------------------------------------------------------*/
go
insert into [order]([accountid],[address],[orderdate],[orderdelivery],[total],[staffid])
values  (  1 , N'address1' , '2023-01-22' , '2023-01-25' , 600000 , 1 ),
		(  2 , N'address2', '2023-02-22' , '2023-02-25' , 424000 , 1 ),
		(  3 , N'address3', '2023-03-22' , '2023-03-25' , 600000 , 2 ),
		(  4 , N'address4', '2023-04-22' , '2023-04-25' , 1000000 , 2 ),
		(  5 , N'address5', '2023-05-22' , '2023-05-25' , 1000000 , 2 )
/*-----------------------------------------------------------------*/
go
insert into [orderdetail]([orderid],[productid],[quantity],[price],[total],[note])
values  ( 1 , 1 , 2 , 300000 , 600000 , null),
		(  2 , 2 , 2 , 212000 , 424000 , null),
		( 3 , 3 , 2 , 300000 , 600000 , null),
		(  4 , 4 , 2 , 500000 , 1000000 , null),
		( 5 , 5 , 2 , 500000 , 1000000 , null)


/*-----------------------------------------------------------------*/
go

insert into [payments]([idaccount],[idorderdetail],[paymentdate],[paymentmethod],[amount])
values  ( 1 , 1 , '2023-01-22' , N'Credit Card' , 600000),
		(  2 , 2 , '2023-02-22' , N'Credit Card' , 424000),
		( 3 , 3 , '2023-03-22' , N'Credit Card' , 600000),
		(  4 , 4 , '2023-04-22' , N'Credit Card' , 1000000),
		(  5 , 5 , '2023-05-22' , N'Credit Card' , 1000000)

/*-----------------------------------------------------------------*/
go
insert into [reviews] ([idaccount],[productid],[rate],[content],[review_date])
values  (  1 , 1 ,4, N'Chất lượng sản phẩm tốt , rất hài lòng' , '2023-02-01'),
		(  2 , 1 ,5, N'Chất lượng sản phẩm tốt , rất hài lòng' , '2023-03-01'),
		(  3 , 1 ,4 , N'Chất lượng sản phẩm tốt , rất hài lòng', '2023-04-01'),
		(  4 , 1 ,5, N'Chất lượng sản phẩm tốt , rất hài lòng' , '2023-05-01'),
		(  5 , 1 ,4 , N'Chất lượng sản phẩm tốt , rất hài lòng', '2023-06-01')
/*-----------------------------------------------------------------*/
go
SET IDENTITY_INSERT [stock] ON
insert into [stock] ([productid],[quantity])
values  ( 1 , 100),
		( 2 , 100),
		( 3 , 100),
		( 4 , 100),
		( 5 , 100),
		( 6 , 100),
		( 7 , 100),
		( 8 , 100),
		( 9 , 100),
		( 10 , 100),
		( 11 , 100),
		( 12 , 100),
		( 13 , 100),
		( 14 , 100),
		( 15 , 100),
		( 16 , 100),
		( 17 , 100),
		( 18, 100),
		( 19 , 100),
		( 20 , 100),
		( 21 , 100),
		( 22 , 100),
		( 23 , 100),
		( 24 , 100),
		( 25 , 100),
		( 26 , 100),
		( 27 , 100),
		( 28 , 100),
		( 29 , 100),
		( 30 , 100),
		( 31 , 100),
		( 32 , 100),
		( 33 , 100),
		( 34 , 100),
		( 35 , 100),
		( 36 , 100),
		( 37 , 100),
		( 38 , 100),
		( 39 , 100),
		( 40 , 100),
		( 41 , 100),
		( 42 , 100),
		( 43 , 100),
		( 44 , 100),
		( 45 , 100),
		( 46 , 100),
		( 47 , 100),
		( 48 , 100),
		( 49 , 100),
		( 50 , 100),
		( 51 , 100)
SET IDENTITY_INSERT [stock] OFF
