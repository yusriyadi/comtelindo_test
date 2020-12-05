package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.d
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.fragment_desciption.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.CourseDetailActivity
import tellabsxcomtelindo.android.klikcoaching.ui.detailcategory.DetailCategoryActivity
import tellabsxcomtelindo.android.klikcoaching.ui.home.MainActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData
import tellabsxcomtelindo.android.klikcoaching.utils.formatRupiah
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask


class DesciptionFragment : Fragment(R.layout.fragment_desciption) {


    val mainGroupAdapter = GroupAdapter<GroupieViewHolder>()

    private var timer: CountDownTimer?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = (activity as CourseDetailActivity).idCourse
        val data = DUmmyData.completeCourse.filter { it.id == id.toInt() }[0]
        tvDeskripsi.text = data.description


        if (!(activity as CourseDetailActivity).isWebBinar) {

            group.visibility = View.GONE

            tvDurasi.text = data.duration
            tvPrice.text = formatRupiah(data.price) + ",-"


            data.courseTopic.forEach {
                val courseItemTopics = GroupAdapter<GroupieViewHolder>()
                it.subCourseSection.forEach {
                    courseItemTopics.add(
                        ItemCourseSubTopic(
                            it
                        )
                    )
                }
                mainGroupAdapter.add(
                    ItemCourseTopic(
                        it.courseSection,
                        courseItemTopics
                    )
                )
            }
            mainGroupAdapter.add(Section(ItemAuthorSection(DUmmyData.author[id.toInt()].name.toString())))
        } else {


            tvLableTAg.text = "Jadwal Webinar"
            textView10.visibility = View.GONE
            tvDurasi.text = data.duration
            tvPrice.text = "08 Juli 2020"

            if ((activity as CourseDetailActivity).isThisDay) {
                tvPrice3.visibility = View.VISIBLE

                timer = object : CountDownTimer(10 * 1000, 1 * 1000) {
                    override fun onFinish() {
                        (activity as CourseDetailActivity).btnBeli.isEnabled = true
                        tvPrice3.visibility = View.GONE
                        tvPrice.text = "Kelas Dimulai!"
                    }

                    override fun onTick(p0: Long) {

                        var millisUntilFinished: Long = p0
                        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes)
                        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
                        tvPrice3.text = "(0$minutes:$seconds)"
                    }

                }.start()

                tvPrice3.text = "(00:59)"
                tvDurasi.text = "19.00 - 20.00"
            }

            mainGroupAdapter.add(Section(ItemAuthorSection(DUmmyData.author[id.toInt()].name.toString())))


            mainGroupAdapter.add(Section(ItemSectionSyaratKetentuan()))

        }

        rvDescriptionCourse.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainGroupAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DesciptionFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}