package com.example.metabook.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.metabook.R

class PersonEditText : AppCompatEditText {

    private var isNameValid: Boolean = false
    private lateinit var personIcon: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        personIcon =
            ContextCompat.getDrawable(context, R.drawable.ic_baseline_person_24) as Drawable
        onShowVisibilityIcon(personIcon)

        addTextChangedListener { text ->
            validateName(text?.trim().toString())
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = resources.getString(R.string.name_required)

        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun validateName(name: String) {
        if (name.isEmpty()) {
            isNameValid = false
            error = resources.getString(R.string.name_required)
        } else {
            isNameValid = true
            error = null
        }
    }

    private fun onShowVisibilityIcon(icon: Drawable) {
        setButtonDrawables(startOfTheText = icon)
    }

    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null,
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )
    }
}
