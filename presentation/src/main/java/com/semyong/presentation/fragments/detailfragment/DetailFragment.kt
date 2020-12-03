package com.semyong.presentation.fragments.detailfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.semyong.entities.Result
import com.semyong.presentation.R
import com.semyong.presentation.helpers.load
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var result: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            result = DetailFragmentArgs.fromBundle(it).result
            result?.let {
                renderScreen(it)
            }
        }
    }

    private fun renderScreen(result: Result) {
        fragment_detail_title_txt.text = result.title
        fragment_detail_title_desc.text = result.abstract

        result.media?.get(0)?.let { media ->
            fragment_detail_caption.text = media.caption
            media.mediaMetadata?.get(0)?.let {
                it.url?.let { img ->
                    fragment_detail_img.load(img)
                }
                fragment_detail_img.layoutParams.width = it.width?.toInt()!!
                fragment_detail_img.layoutParams.height = it.height?.toInt()!!
                fragment_detail_img.requestLayout()
            }
        }
    }
}

