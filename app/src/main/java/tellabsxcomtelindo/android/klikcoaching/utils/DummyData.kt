package tellabsxcomtelindo.android.klikcoaching.utils

import androidx.lifecycle.MutableLiveData
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.*
import tellabsxcomtelindo.android.klikcoaching.ui.kategori.CategoryMenus
import tellabsxcomtelindo.android.klikcoaching.ui.mycourse.HeaderAndCourse

object DummyData {

    val completeCourse = mutableListOf<Courses>()
    val dataDummyAllCourse = mutableListOf<HeaderAndCourse>()
    val dataDummyOfflineCourse = MutableLiveData<MutableList<HeaderAndCourse>>(mutableListOf<HeaderAndCourse>())


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

        generateOnlineCourse()
        generateOfflineCourse()
    }

    private fun generateOfflineCourse() {

        for (i in 0..0) {
            val data = mutableListOf<Courses>()
            for (j in 0..1) {
                    data.add(completeCourse[(0..4).random()])
            }
            val listbaru: HeaderAndCourse = HeaderAndCourse(menusCategory[i].title, data)
            dataDummyOfflineCourse.postValue(mutableListOf(listbaru))
        }
    }

    private fun generateOnlineCourse() {
        dataDummyAllCourse.clear()
        for (i in 0..2) {
            val data = mutableListOf<Courses>()
            for (j in 0..2) {
                if (j % 2 == 0) {
                    data.add(completeCourse[(5..9).random()])
                } else {
                    data.add(completeCourse[(0..4).random()])
                }
            }
            dataDummyAllCourse.add(HeaderAndCourse(menusCategory[i].title, data))
        }
    }


}