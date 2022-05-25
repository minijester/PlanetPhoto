package com.miharu.planetphoto.presenter.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment constructor(@LayoutRes val contentLayoutId: Int) :
    Fragment(contentLayoutId)