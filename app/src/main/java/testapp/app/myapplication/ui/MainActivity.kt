package testapp.app.myapplication.ui

import android.os.Bundle
import testapp.app.myapplication.R
import testapp.app.myapplication.modelpojo.UserData
import testapp.app.myapplication.presenter.MainActivityPresenter
import testapp.app.myapplication.ui.baseactivity.BaseActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.android.databinding.library.baseAdapters.BR
import testapp.app.myapplication.ui.adapter.BaseDataBindAdapter
import testapp.app.myapplication.ui.adapter.user.OnClickContractDataUser


class MainActivity : BaseActivity(), MainActivityPresenter.ViewPresenter, MainActivityPresenter.RouterPresenter, OnClickContractDataUser {

    private lateinit var mBaseDataBindAdapter: BaseDataBindAdapter<UserData>

    @Inject
    lateinit var mPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject(this)
        mPresenter.init()
    }

    override fun onSetItems(listData: List<UserData>) {
            val mLayoutManager = LinearLayoutManager(this)
            recyclerView_user.layoutManager = mLayoutManager
            mBaseDataBindAdapter = BaseDataBindAdapter(R.layout.item_data_user, BR.userData, listData, this)
            recyclerView_user.adapter = mBaseDataBindAdapter
    }

    override fun clickUser() {
        //Do some for event click User item
        Log.i("Test", "Click")
    }
}
