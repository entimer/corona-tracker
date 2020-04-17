package io.github.entimer.coronatracker.ui.main.dashboard

import android.content.Context
import android.view.View
import io.github.entimer.coronatracker.ui.base.IMvp
import io.github.entimer.coronatracker.util.dataclass.CaseData

class DashboardPresenter(view: IMvp.View.Dashboard, fragmentView: View): IMvp.Presenter.Dashboard {
    private val view = view
    private val fragmentView = fragmentView
    private val model = DashboardModel(this)

    override fun getData(context: Context) {
        model.getGlobalCount(context)
    }

    override fun updateCount(data: CaseData) {
        view.updateCount(fragmentView, data)
    }

    override fun updatePieChart() {

    }

    override fun updateLineChart() {

    }

    override fun updateBarChart() {

    }
}