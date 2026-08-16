
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class validateCitizenIdTest {

    @Test
    fun `valid 13 digit id retuns true`() {
        val id ="1107254911076"

        val result = validateCitizenId(id)

        assertTrue(result)
    }

    @Test
    fun `id with wrong length retuns false`() {
        assertFalse(validateCitizenId("12345"))//สั้นไป
        assertFalse(validateCitizenId("12345678910111213"))//ยาวไป
    }

    @Test
    fun `id with wrong ids retuns false`() {
        assertFalse(validateCitizenId("abcdefghijklm"))//ตัวอักษร
        assertFalse(validateCitizenId("123456789101a"))//มีตัวอักษรบางส่วน
    }

    @Test
    fun `id with wrong checksum returns false`() {
        // หลักที่ 13 ต้องเป็น check digit ที่คำนวณจาก 12 หลักแรก
        // 110170018520 → check digit ที่ถูกต้องคือ 6
        assertFalse(validateCitizenId("1101700185207")) // หลักสุดท้ายผิด
        assertFalse(validateCitizenId("1234567890129")) // ที่ถูกคือ ...1

        // ใบที่ checksum ถูกต้อง ต้องยังผ่านอยู่
        assertTrue(validateCitizenId("3509900547250"))
        assertTrue(validateCitizenId("1234567890121"))
    }

    @Test
    fun `id with thai number returns true`(){
        assertTrue(validateCitizenId("๑๒๓๔๕๖๗๘๙๐๑๒๑"))
    }

}