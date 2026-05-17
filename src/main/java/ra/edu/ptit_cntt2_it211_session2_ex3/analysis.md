1. Vai trò của HTTP Status Codes trong Robust API
   Trong kiến trúc RESTful API, HTTP Status Codes đóng vai trò là "ngôn ngữ chung toàn cầu" ở tầng giao thức mạng. Một hệ thống vững chắc (Robust API) bắt buộc phải dùng mã này để thông báo trạng thái xử lý
2. Tác hại của việc trả về null hoặc {} thay vì 404 Not Found
   Khi một mặt hàng (Item) không tồn tại, nếu Server trả về giá trị null hoặc chuỗi rỗng {} nhưng dán nhãn phong bì mạng là 200 OK, nó sẽ gây ra các hậu quả nghiêm trọng:
   Đánh lừa Client (False Positive): Mã 200 OK ép các thư viện Client hiểu rằng "Yêu cầu đã thành công". Khi Client nhảy vào nhánh xử lý dữ liệu đúng, việc cố gắng truy cập các thuộc tính của một đối tượng rỗng sẽ lập tức bẻ gãy ứng dụng Client, gây ra lỗi crash giao diện.
   Phá vỡ tính ngữ nghĩa của REST: REST định nghĩa mỗi thực thể là một tài nguyên. Nếu tài nguyên không tồn tại, mã mạng bắt buộc phải là 404 Not Found. Việc lạm dụng mã 200 OK cho trường hợp lỗi làm mất đi tính minh bạch và chuẩn hóa của hệ thống.
3. Tại sao jackson-dataformat-xml lại cần thiết cho Content Negotiation?
   Mặc định, Spring Boot Starter Web chỉ được trang bị sẵn bộ chuyển đổi dữ liệu (HttpMessageConverter) của Jackson dành riêng cho định dạng JSON.