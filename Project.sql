USE [project]

GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 3/24/2021 1:30:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[username] [varchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[phone] [varchar](50) NOT NULL,
	[address] [nvarchar](100) NOT NULL,
	[role] [nvarchar](100) NOT NULL,
	
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bills]    Script Date: 3/24/2021 1:30:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bills](
	[bid] [varchar](50) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[pid] [varchar](50) NOT NULL,
	[date] [datetime] NOT NULL,
	[amount] [int] NOT NULL,
	[total] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts]    Script Date: 3/24/2021 1:30:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[username] [varchar](50) NOT NULL,
	[pid] [varchar](50) NOT NULL,
	[amount] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 3/24/2021 1:30:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[catid] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[catid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 3/24/2021 1:30:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[pid] [varchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[catid] [varchar](50) NOT NULL,
	[image] [varchar](max) NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Accounts] ([username], [password], [fullname], [email], [phone], [address], [role]) VALUES (N'admin', N'123', N'Đoàn Trọng Thái', N'admin@gmail.com', N'0337305098', N'Yen Bai', 1)
INSERT [dbo].[Accounts] ([username], [password], [fullname], [email], [phone], [address], [role]) VALUES (N'hung123', N'123', N'Thái', N'Thai@gmail.com', N'0973304612', N'Hai Phong', 0)
GO
INSERT [dbo].[Bills] ([bid], [username], [pid], [date], [amount], [total]) VALUES (N'c7c32d6c-9bf4-4dcc-b990-68a14f8189d8', N'hung123', N'b3', CAST(N'2021-03-22T13:46:36.300' AS DateTime), 2, 50.520000457763672)
INSERT [dbo].[Bills] ([bid], [username], [pid], [date], [amount], [total]) VALUES (N'b0a7cdab-ab15-4456-b043-0017245dfb5e', N'hung123', N'b1', CAST(N'2021-03-22T13:46:36.303' AS DateTime), 2, 55.979999542236328)
INSERT [dbo].[Bills] ([bid], [username], [pid], [date], [amount], [total]) VALUES (N'bc1d1871-5ac3-4de3-9a94-ae97823f94e4', N'admin', N'b2', CAST(N'2021-03-24T13:19:17.893' AS DateTime), 2, 28.819999694824219)
INSERT [dbo].[Bills] ([bid], [username], [pid], [date], [amount], [total]) VALUES (N'8e627439-e92c-4fb5-9891-0d656ae2c5a0', N'admin', N'b1', CAST(N'2021-03-24T13:19:17.897' AS DateTime), 1, 27.989999771118164)
INSERT [dbo].[Bills] ([bid], [username], [pid], [date], [amount], [total]) VALUES (N'101609be-0fa3-4bc7-b8d0-c9457cf784ee', N'admin', N'b3', CAST(N'2021-03-14T20:38:03.880' AS DateTime), 1, 25.260000228881836)
INSERT [dbo].[Bills] ([bid], [username], [pid], [date], [amount], [total]) VALUES (N'a97ccde1-0274-435f-aecc-2dc5a42a5f23', N'admin', N'b9', CAST(N'2021-03-14T20:38:16.573' AS DateTime), 1, 10.590000152587891)
GO
INSERT [dbo].[Categories] ([catid], [name]) VALUES (N'cat1', N'Văn Học')
INSERT [dbo].[Categories] ([catid], [name]) VALUES (N'cat2', N'Văn Hóa - Xã Hội')
INSERT [dbo].[Categories] ([catid], [name]) VALUES (N'cat3', N'Tâm Linh - Tôn Giáo')
GO
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b1', N'Giết con chim nhại', N'Giết con chim nhại lấy bối cảnh Alabama, một tiểu bang miền Nam rất nặng thành kiến phân biệt chủng tộc và được viết trong thời gian mà phong trào đấu tranh của những người da màu, nhất là của Martin Luther King, Jr., đang lan rộng tới tầm cỡ quốc gia. Rõ nhất là vụ Tẩy chay xe buýt ở Mongomery, Alabama; kéo dài từ tháng 12 năm 1955 đến tháng 12 năm 1956, với kết quả là một phán quyết của Tối cao pháp viện tuyên bố các luật phân cách chỗ ngồi trên xe buýt theo màu da được áp dụng ở Montgomery và cả Alabama là vi hiến. Nên không ngạc nhiên gì khi chủ đề lớn của tác phẩm là vấn đề phân biệt chủng tộc.',
 27.99, 10, N'cat1', N'https://th.bing.com/th/id/R.eaf02a90f71bc12453ecedc50ca39c60?rik=yDl9eb37nw%2boCA&riu=http%3a%2f%2fsach86.com%2fwp-content%2fuploads%2f2020%2f04%2fGiet-Con-Chim-Nhai.jpg&ehk=0KPiiYxi5YhTUDjCB%2fwl2reeHSOAhXNu2JBLUAGbrMY%3d&risl=&pid=ImgRaw&r=0')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b2', N'Biên niên ký chim vặn dây cót', N'Phần thứ nhất (Chim ác là ăn cắp), bắt đầu bằng việc Toru Okada, đang thất nghiệp, được vợ là Kumiko lệnh cho phải tìm được con mèo mất tích của họ. Kumiko gợi ý rằng việc tìm kiếm nên bắt đầu ở khu vực hàng xóm xung quanh, nhất là khoảng đất bỏ hoang phía sau nhà anh. Sau nhiều lần thử tìm mà không được, Toru gặp Kasahara May, cô bé đã nhiều lần thấy anh trèo ra trèo vào chỗ đất xung quanh, đâm ra tò mò và đặt cho anh nhiều câu hỏi. Rồi May mời Toru qua nhà cô, cùng ngồi trò chuyện ở hàng hiên và hứa sẽ tìm giúp con mèo cho anh. Cuộc trò chuyện cũng hé lộ nhiều tình tiết về "Những vận dớp trong căn nhà bị bỏ hoang" (Nhà của gia đình Miyawaki- bị vỡ nợ, cả nhà tự sát) mà Toru trèo vào tìm con mèo trong đó. Toru cũng nhận được những cuộc điện thoại lạ của một người phụ nữ có vẻ như đang muốn khiêu khích tình dục anh....', 14.41, 10, N'cat1', N'https://sach86.com/wp-content/uploads/2020/11/Bien-Nien-Ky-Chim-Van-Day-Cot-661x1024.jpg')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b3', N'Vòng quanh thế giới trong 80 ngày', N'Câu chuyện bắt đầu ở Luân Đôn vào ngày 2 tháng 10 năm 1872. Phileas Fogg là một người đàn ông giàu có, cô độc, chưa lập gia đình với nhiều thói quen bình thường. Nguồn gốc của tài sản của ông ta không ai biết và ông sống khá khiêm tốn. Ông đã sa thải người tùy tùng trước đây, James Forster, vì đem đến nước cạo râu lạnh hơn 2 độ so với thường lệ và loại một nhân viên cũ của ông vì đưa một bữa sáng trễ hơn ngày thường 1 phút. Ông thuê người tùy tùng mới tên là Passepartout, một người Pháp khoảng 30 tuổi.

Sau đó cùng trong ngày tại Câu lạc bộ Cải cách, ông tham gia vào một cuộc tranh cãi về một bài báo trên tờ nhật báo The Daily Telegraph, nói rằng với việc mở ra một đoạn đường sắt ở Ấn Độ mới, bây giờ người ta có thể đi vòng quanh thế giới trong 80 ngày', 25.26, 10, N'cat1', N'https://upload.wikimedia.org/wikipedia/vi/3/3a/V%C3%B2ng_quanh_th%E1%BA%BF_gi%E1%BB%9Bi_trong_80_ng%C3%A0y_%28s%C3%A1ch%29.jpg')

INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b4', N'Theo Dấu Các Văn Hóa Cổ','Nội dung gồm những bài viết tiêu biểu cho việc nghiên cứu từng thời kỳ khảo cổ học: Thời đại đồ đá, thời đại kim khí và thời đại lịch sử. Từ văn hóa Sơn Vi đến văn hóa Hòa Bình, văn hóa Bắc Sơn… Qua đó giúp người đọc thấy rõ những biến chuyển của Văn hóa Việt Nam cũng như văn hóa trong khu vực Đông Nam Á.', 13.18, 10, N'cat2', N'https://th.bing.com/th/id/R.2a1c2edfe73974d962460cf457d1752d?rik=h4Aj8JRbljurHA&riu=http%3a%2f%2fthinhvuongvietnam.com%2fContent%2fUploadFiles%2fEditorFiles%2fimages%2f2020%2fQuy3%2ftheo-dau-van-hoa-co09092020085641.jpg&ehk=6c2RImgPEczxUssEgRaa1zCbfOYk4viwGWV4eJz231A%3d&risl=&pid=ImgRaw&r=0')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b5', N'Người Việt Trong Dòng Lịch Sử Văn Hóa', N'Trình bày khái quát chân dung người Việt trong mối quan hệ với môi trường tự nhiên, môi trường xã hội và với chính mình. Người Việt trước Cách mạng tháng Tám năm 1945 với những kiểu dạng cụ thể: người nông dân, người thành thị, người thợ thủ công, người buôn bán, nhà nho, người trí thức tân họ với các khía cạnh mưu sinh, ẩm thực, trang phục, đi lại, một số biểu hiện của văn hóa xã hội và văn hóa tinh thần.', 11.91, 10, N'cat2', N'https://salt.tikicdn.com/ts/product/09/61/8c/764328c0f289b0f092d67f2822a48fde.jpg')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b6', N'“Sốc” Văn Hóa', N'Những sốc văn hóa đã xảy ra trong nhà mỗi người chứ không phải là khi sang các nước khác sinh sống hoặc có cuộc hôn nhân khác chủng tộc. Ai cũng biết sự tác động của nhịp sống công nghiệp đến gia đình theo cả hai chiều tốt, xấu. Những thay đổi lớn đang diễn ra. Con người đang bị thách thức trước chủ nghĩa tiêu dùng và chủ nghĩa cá nhân mới.', 9.25, 10, N'cat2', N'https://readvii.com/wp-content/uploads/2020/07/sach-soc-van-hoa-nguyen-thi-ngoc-hai.png')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b7', N'Khám Phá Thế Giới Tâm Linh', N'“Khám phá thế giới tâm linh” đã dẫn dắt người đọc khám phá thế giới tâm hồn chính mình, khám phá tâm linh, những ảnh hưởng của những yếu tố có thật bên ngoài đến đời sống tinh thần của mỗi con người. Hay cùng cuốn sách vén màn những bí ẩn, những điều còn mơ hồ sâu bên trong bạn, để hoàn thiện mình hơn, hay đơn giản chỉ thỏa mãn trí tò mò. Tất cả, sẽ nằm trong cuốn sách', 19.59, 10, N'cat3', N'https://nhatrangbooks.com/wp-content/uploads/2019/10/kham-pha-the-gioi-tam-linh-a.jpg')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b9', N'Đắc Nhân Tâm', N'Hiện nay có một sự hiểu nhầm đã xảy ra. Tuy Đắc Nhân Tâm là tựa sách hầu hết mọi người đều biết đến, vì những danh tiếng và mức độ phổ biến, nhưng một số người lại “ngại” đọc. Lý do vì họ tưởng đây là cuốn sách “dạy làm người” nên có tâm lý e ngại. Có lẽ là do khi giới thiệu về cuốn sách, người ta luôn gắn với miêu tả đây là “nghệ thuật đối nhân xử thế”, “nghệ thuật thu phục lòng người”… Những cụm từ này đã không còn hợp với hiện nay nữa, gây cảm giác xa lạ và không thực tế.', 20.0, 10, N'cat3', N'https://sach86.com/wp-content/uploads/2020/01/Dac-Nhan-Tam-788x1147.jpg')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b8', N'Hành Trình Về Phương Đông', N'"Hành Trình Về Phương Đông" kể về những trải nghiệm của một đoàn khoa học gồm các chuyên gia hàng đầu của Hội Khoa Học Hoàng Gia Anh được cử sang Ấn Độ nghiên cứu về huyền học và những khả năng siêu nhiên của con người. Suốt hai năm trời rong ruổi khắp các đền chùa Ấn Độ, chúng kiến nhiều pháp luật, nhiều cảnh mê tín dị đoan, thậm chí lừa đảo...của nhiều pháp sư, đạo sĩ...họ được tiếp xúc với những vị thế, họ được chứng kiến, trải nghiệm, hiểu biết sâu sắc về các khoa học cổ xưa và bí truyền của văn hóa Ấn Độ như Yoga, thiền định, thuật chiêm duyên, nghiệp báo, luật nhân quả, cõi sống và cõi chết....

Đúng lúc một cuộc đối thoại cởi mở và chân thành đang sắp diễn ra với các đạo sĩ bậc thầy, thì đoàn nhận được tối hậu thu từ chính quyền Anh Quốc là phải ngừng ngay việc nghiên cứu, tức khắc hồi hương và bị buộc phải im lặng, không được phát ngôn về bất cứ điều gì mà họ đã chứng nghiệm. Sau cùng ba nhà khoa học trong đoàn đã chấp nhận bỏ lại tất cả sau lưng, ở lại Ấn Độ tiếp tục nghiên cứu và cuối cùng trở thành tu sĩ. Trong số đó có giáo sư Salding- tác giả hồi ký đặc biệt này.', 14.99, 10, N'cat3', N'https://sachtamlinh.vn/wp-content/uploads/2019/12/hanh-trinh-ve-phuong-dong-1.jpg')
INSERT [dbo].[Products] ([pid], [name], [description], [price], [quantity], [catid], [image]) VALUES (N'b10', N'Con Đường Hồi Giáo', N'Cuốn sách là hành trình đi qua 13 nước Trung Đông mang đến cho bạn đọc bức tranh chân thực về đời sống tôn giáo, tâm linh ở nơi sản sinh 3 nền tôn giáo lớn trên thế giới (Do Thái, đạo Ki-tô và Hồi Giáo) và cũng là nơi thường xuyên xảy ra các cuộc xung đột tôn giáo.

13 đất nước là 13 trải nghiệm Từ những khám phá về Trung Đông, đến Trung Đông ngùn ngụt khói lửa chiến tranh, hay một Trung Đông tâm linh huyền bí,… đã được tác giả Nguyễn Mai Phương ghi lại. Không chỉ mang giá trị về tôn giáo, cuốn sách còn là những trải nghiệm về du lịch, khám phá những nền văn hóa khác.',17.99, 10, N'cat3', N'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1395048365l/21474711.jpg')
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Accounts] FOREIGN KEY([username])
REFERENCES [dbo].[Accounts] ([username])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Accounts]
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Products] FOREIGN KEY([pid])
REFERENCES [dbo].[Products] ([pid])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Products]
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FK_Carts_Accounts] FOREIGN KEY([username])
REFERENCES [dbo].[Accounts] ([username])
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FK_Carts_Accounts]
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FK_Carts_Products] FOREIGN KEY([pid])
REFERENCES [dbo].[Products] ([pid])
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FK_Carts_Products]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([catid])
REFERENCES [dbo].[Categories] ([catid])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO
select * from [Products]