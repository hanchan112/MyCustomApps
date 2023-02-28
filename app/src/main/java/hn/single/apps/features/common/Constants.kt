package hn.single.apps.features.common

object Constants {

    const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val CALL_TIMEOUT: Long = 30_000
    const val CONNECT_TIMEOUT: Long = 30_000
    const val READ_TIMEOUT: Long = 30_000
    const val WRITE_TIMEOUT: Long = 30_000

    //https://tracau.vn/pages/api.html
    /*# Tra câu và tra từ Anh - Việt, Việt - Anh:
    https://api.tracau.vn/{api-key}/s/{value}/{lang}
    # Tra từ điển Pháp - Anh - Việt:
    https://api.tracau.vn/{api-key}/df/{value}
    # Tra từ điển Tiếng Nhật - Anh - Việt:
    https://api.tracau.vn/{api-key}/dj/{value}
    # Tìm kiếm phụ đề phim:
    https://api.tracau.vn/{api-key}/sub/{value}/{lang}
    # Tìm kiếm bản dịch trên Youtube:
    https://api.tracau.vn/{api-key}/trans/{value}
    Giải thích:
    {api-key} được mặc định bằng giá trị sau: WBBcwnwQpV89
    {value} là ý của câu cần tìm kiếm
    {lang} là ngôn ngữ cần tìm kiếm với các giá trị tùy chọn sau: en, vi*/
    private const val API_KEY = "WBBcwnwQpV89"
    const val BASE_URL_TRACAU = "https://api.tracau.vn/$API_KEY"

    const val POSITION_0 = 0
    const val POSITION_1 = 1
    const val POSITION_2 = 2
}