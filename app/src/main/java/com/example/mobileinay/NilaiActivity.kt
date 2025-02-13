package com.example.mobileinay


//import com.example.mobileinay.retrofit.ApiClient
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NilaiActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserNilai
    private lateinit var spinnerSemester: Spinner
    private lateinit var spinnerNilai: Spinner

    private val dataNilai = listOf(
//        Semester 1
        nilai("Matematika", 80, 85, 90, 1),
        nilai("Bahasa Indonesia", 78, 82, 88, 1),
        nilai("IPA", 85, 80, 89,1),
        nilai("IPS", 83, 81, 86, 1),
//          Semester 2
        nilai("Matematika", 85, 88, 92, 2),
        nilai("Bahasa Indonesia", 80, 84, 90,2),
        nilai("IPA", 87, 82, 91,2),
        nilai("IPS", 84, 85, 89,2)
    )
    private var selectedSemester = 1
    private var selectedType = "UTS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)
        supportActionBar?.hide()

//      imageButton
        val btnBack: ImageButton = findViewById(R.id.img_kembali)

        btnBack.setOnClickListener {
            finish()
        }

        recyclerView = findViewById(R.id.recyclerView)
        spinnerSemester = findViewById(R.id.SpinnerSemester)
        spinnerNilai = findViewById(R.id.SpinnerNilai)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = UserNilai(dataNilai)
//        recyclerView.adapter = adapter

        val semesterOptions = arrayOf("Semester 1", "Semester 2")
        val semesterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, semesterOptions)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter

        val nilaiOptions = arrayOf("UTS", "UAS", "Tugas")
        val nilaiAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nilaiOptions)
        nilaiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerNilai.adapter = nilaiAdapter

        spinnerSemester.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedSemester = position + 1
                updateRecyclerView()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        }
        spinnerNilai.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedType = nilaiOptions[position]
                updateRecyclerView()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        adapter = UserNilai(filterData())
        recyclerView.adapter = adapter
    }

    private fun filterData(): List<Pair<String, Int>> {
    return  dataNilai.filter { it.semester == selectedSemester }
        .map {
            val nilai = when(selectedType){
                "UTS" -> it.uts
                "UAS" -> it.uas
                "Tugas" -> it.tugas
                else -> 0
            }
            Pair(it.mapel, nilai)
        }
    }

    private fun updateRecyclerView() {
        val filterData = filterData()
        adapter.updateData(filterData)
    }

}
