package io.github.entimer.coronatracker.ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import io.github.entimer.coronatracker.R
import kotlinx.android.synthetic.main.layout_card_chart.view.*
import kotlinx.android.synthetic.main.layout_card_worldwide.view.*
import java.text.DecimalFormat

class DashboardFragment: Fragment() {
    private var confirmed = 1696139
    private var recovered = 376200
    private var death = 102669

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_dashboard, container, false)

        initWorldwideCard(view)
        initChartCart(view)

        return view
    }

    private fun initWorldwideCard(view: View) {
        val decimalFormat = DecimalFormat("###,###")
        view.dashboard_worldwide_confirmed.text = decimalFormat.format(confirmed)
        view.dashboard_worldwide_recovered.text = decimalFormat.format(recovered)
        view.dashboard_worldwide_death.text = decimalFormat.format(death)
    }

    private fun initChartCart(view: View) {
        //Data values
        val confirmedF = confirmed.toFloat()
        val recoveredF = recovered.toFloat()
        val deathF = death.toFloat()
        var percentActive = (confirmedF - recoveredF - deathF) / confirmedF * 100f
        var percentRecovered = recoveredF / confirmedF * 100f
        var percentDeath = deathF / confirmedF * 100f

        //Init pie chart view
        view.dashboard_chart.setUsePercentValues(true)
        view.dashboard_chart.description.isEnabled = false
        view.dashboard_chart.holeRadius = 55.0f
        view.dashboard_chart.transparentCircleRadius = 60.0f

        view.dashboard_chart.centerText = activity.getString(R.string.chart_center_text)
        view.dashboard_chart.setCenterTextSize(20.0f)

        view.dashboard_chart.isRotationEnabled = true
        view.dashboard_chart.rotationAngle = 0.0f

        view.dashboard_chart.isHighlightPerTapEnabled = true

        //Make data entries
        var entries = ArrayList<PieEntry>()

        entries.add(PieEntry(percentActive, activity.getString(R.string.active)))
        entries.add(PieEntry(percentRecovered, activity.getString(R.string.recovered)))
        entries.add(PieEntry(percentDeath, activity.getString(R.string.death)))

        //Make data set
        val dataSet = PieDataSet(entries, "")
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 8f

        //Chart colors
        val colorSet = ArrayList<Int>()
        colorSet.add(activity.resources.getColor(R.color.colorConfirmed))
        colorSet.add(activity.resources.getColor(R.color.colorRecovered))
        colorSet.add(activity.resources.getColor(R.color.colorDeath))
        dataSet.colors = colorSet

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(view.dashboard_chart))
        data.setValueTextSize(11f)
        data.setValueTextColor(activity.resources.getColor(R.color.colorOnPrimary))

        view.dashboard_chart.data = data
        view.dashboard_chart.invalidate()
    }
}