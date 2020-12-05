package tellabsxcomtelindo.android.klikcoaching.utils

import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.*
import tellabsxcomtelindo.android.klikcoaching.ui.kategori.CategoryMenus

object DUmmyData {
    val coursesRecomeded = mutableListOf<Courses>()
    val newComerCource = mutableListOf<Courses>()
    val completeCourse = mutableListOf<Courses>()

    val category = mutableListOf<String>("Music","Design", "Programming","Automotive","Mechanical","finance")
    val menusCategory = listOf<CategoryMenus>(
        CategoryMenus(R.drawable.img_single_guitar, "Music"),
        CategoryMenus(R.drawable.img_yellow_decoration, "Design"),
        CategoryMenus(R.drawable.img_coding, "Programming"),
        CategoryMenus(R.drawable.img_car_engine, "Automative"),
        CategoryMenus(R.drawable.img_workshop, "Mechanical"),
        CategoryMenus(R.drawable.img_calculator, "Finance")
    )
    val courseTitle = mutableListOf<String>(
        "Quicstart Acoustic Guitar",
        "Acounting 101",
        "Car Engine Treatment tips",
        "Android Kotlin Fundamental",
        "Grow up your painting skill",
        "Guitar Lesson : Beginner Acoustic guitar lesson",
        "Android Kotlin Fundamental Batch 2",
        "Grow up your bussiness",
        "learn about your Tools!",
        "How About Architecture!"
    )

    val author = listOf<Author>(
        Author("yusri al-paseri"),
        Author("ibnu surkati"),
        Author("mahmud bin zainal"),
        Author("ahmad "),
        Author("yudi al-kayuwangi"),
        Author("dwi si senja"),
        Author("dindaaa"),
        Author("kamilia"),
        Author("ainun "),
        Author("mahmudin")
    )

    val mutableListImage = mutableListOf<Int>(
        R.drawable.img_fingerstyle,
        R.drawable.img_calculator,
        R.drawable.img_car_engine,
        R.drawable.img_coding,
        R.drawable.img_coloring_tools,
        R.drawable.img_guitar,
        R.drawable.img_coding,
        R.drawable.img_calculator,
        R.drawable.img_workshop,
        R.drawable.img_yellow_decoration
    )
    init {
        generateData()
    }

    fun generateData() {
        for (i in 0..9){
            completeCourse.add(
                Courses(
                    i,
                    courseTitle[i],
                    author[i],
                    4.8,
                    "ini merupakan deskripsi penjelasan dari setiap topik pembelajaran. Usahakan selalu lengkapi deskripsi ini. Tidak perlu panjang, yang penting padat, bermakana, tepat sasaran, jelas dan lugas",
                    (1..3).random().toDouble()*100000.0,
                    mutableListImage[i],
                    (0..2).random().toString()+" jam 20 menit",
                    listOf(
                        fingerStyleFirstTopic,
                        fingerStyleSecondTopic
                    ),
                    i >=5,
                    ""
                )
            )
        }

        for (i in 0..4) {
            coursesRecomeded.add(
                Courses(
                    i,
                    courseTitle[i],
                    author[i],
                    4.8,
                    "ini merupakan deskripsi penjelasan dari setiap topik pembelajaran. Usahakan selalu lengkapi deskripsi ini. Tidak perlu panjang, yang penting padat, bermakana, tepat sasaran, jelas dan lugas",
                    (1..3).random().toDouble()*100000.0,
                    mutableListImage[i],
                    (0..2).random().toString()+" jam 20 menit",
                    listOf(
                        fingerStyleFirstTopic,
                        fingerStyleSecondTopic
                    ),
                    false,
                    ""
                )
            )
        }

        for (i in 5..9) {
            newComerCource.add(
                Courses(
                    i,
                    courseTitle[i],
                    author[i],
                    4.8,
                    "ini merupakan deskripsi penjelasan dari setiap topik pembelajaran. Usahakan selalu lengkapi deskripsi ini. Tidak perlu panjang, yang penting padat, bermakana, tepat sasaran, jelas dan lugas",
                    (1..3).random().toDouble()*100000.0,
                    mutableListImage[i],
                    (0..2).random().toString()+" jam 20 menit",
                    listOf(
                        fingerStyleFirstTopic,
                        fingerStyleSecondTopic
                    ),
                    true,
                    ""
                )
            )
        }
    }


}