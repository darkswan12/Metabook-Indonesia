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

class PasswordEditText : AppCompatEditText {

    private lateinit var lockImage: Drawable
    private var isPassValid: Boolean = false

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
        lockImage = ContextCompat.getDrawable(context, R.drawable.ic_baseline_lock_24) as Drawable
        onShowVisibilityIcon(lockImage)

        addTextChangedListener(onTextChanged = { _: CharSequence?, _: Int, _: Int, _: Int ->
            validatePassword()
        })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = resources.getString(R.string.input_password)
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun validatePassword() {
        val pass = text?.trim()
        when {
            pass.isNullOrEmpty() -> {
                isPassValid = false
                error = resources.getString(R.string.input_password)
            }

            pass.length < 8 -> {
                isPassValid = false
                error = resources.getString(R.string.password_length)
            }

            else -> {
                isPassValid = true
                error = null
            }
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
