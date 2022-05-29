package com.miharu.planetphoto.core.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.miharu.planetphoto.core.util.FragmentViewBindingDelegate

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)