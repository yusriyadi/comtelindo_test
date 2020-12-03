package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_ulasan.*
import tellabsxcomtelindo.android.klikcoaching.R


class UlasanFragment : Fragment(R.layout.fragment_ulasan) {

    private val groupAdatper = GroupAdapter<GroupieViewHolder>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reviews = mutableListOf<CourseReview>(
            CourseReview(
                "Pranay Jain",
                3.0,
                "Execllent Course! Easy to understand, clear explanations, infomative, very well origanized, I always wanted such type..."
            ),
            CourseReview(
                "Narenda Prabhu",
                5.0,
                "I had no previous exposure to any progarmming langunange, but I culd still get a good understanding of the language"
            ),
            CourseReview(
                "usery.id",
                5.0,
                "Pokoke mantep"
            ),
            CourseReview(
                "Rezu chan",
                4.0,
                "Execllent Course! Easy to understand, clear explanations, infomative, very well origanized, I always wanted such type..."
            ),
            CourseReview(
                "Pranay Jain",
                3.0,
                "Execllent Course! Easy to understand, clear explanations, infomative, very well origanized, I always wanted such type..."
            )
        )


        reviews.forEach {
            groupAdatper.add(
                ItemCourseReview(
                    it
                )
            )
        }


        rvReview.apply {
            adapter = groupAdatper
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UlasanFragment()
    }
}