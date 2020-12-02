package tellabsxcomtelindo.android.klikcoaching.data

import tellabsxcomtelindo.android.klikcoaching.R

data class HomeResponse(val tags: List<Category>)
data class Category(
    val tag: String,
    val courses: List<Courses>
)

data class Courses(
    val id: Int,
    val title: String,
    val author: Author,
    val rating: Double,
    val description: String,
    val price: Double,
    val imageBanner : Int,
    val duration: String,
    val courseTopic: List<CourseTopic>
)

data class CourseTopic(
    val courseSection: String,
    val subCourseSection: List<String>
)

data class Author(
    val name: String? = "udin",
    val expertise: String? = "", val subscriber: String? = "", val seminar: String? = ""
)


val udinAuthor = Author("udin")

val homeResponse = HomeResponse(listOf<Category>())

val fingerStyleFirstTopic = CourseTopic(
    "Pembelajaran Dasar | 3 Mater",
    listOf("Pembelajran Dasar 1", "Pembelajran Dasar 2", "Pembelajran Dasar 3")
)
val fingerStyleSecondTopic = CourseTopic(
    "Teknik Dasar | 3 Materi",
    listOf("Teknik Dasar 1", "Teknik Dasar 2", "Teknik Dasar 3")
)

val musicCategory1 = Category(
    "Music", listOf<Courses>(
        Courses(
            1,
            "The Best Beginer FingerStyle Guitar Lesson",
            udinAuthor,
            4.8,
            "ini merupakan deskripsis penjelasann dari setipa topik pembelajaran",
            120000.0,
            R.drawable.img_fingerstyle,
            "3 jam 20 menit",
            listOf(
                fingerStyleFirstTopic,
                fingerStyleSecondTopic
            )
        ),
        Courses(
            1,
            "The Best Beginer FingerStyle Guitar Lesson",
            udinAuthor,
            4.8,
            "ini merupakan deskripsis penjelasann dari setipa topik pembelajaran",
            120000.0,
            R.drawable.img_fingerstyle,
            "3 jam 20 menit",
            listOf(
                fingerStyleFirstTopic,
                fingerStyleSecondTopic
            )
        )
    )
)
