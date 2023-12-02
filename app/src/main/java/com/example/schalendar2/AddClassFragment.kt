package com.example.schalendar2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddClassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_class, container, false)

        val saveButton: Button = view.findViewById(R.id.savebutton)
        val editTextClassName: EditText = view.findViewById(R.id.edittextclassname)
        val editTextClassLocation: EditText = view.findViewById(R.id.edittextclasslocation)
        val datePicker: DatePicker = view.findViewById(R.id.datepickerclassdate)
        val timePicker: TimePicker = view.findViewById(R.id.timepickerclasstime)

        saveButton.setOnClickListener {
            val className = editTextClassName.text.toString()
            val classLocation = editTextClassLocation.text.toString()

            val year = datePicker.year
            val month = datePicker.month
            val day = datePicker.dayOfMonth
            val calendar = Calendar.getInstance().apply { set(year, month, day) }
            val classDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time)

            val hour = timePicker.hour
            val minute = timePicker.minute
            val classTime = String.format("%02d:%02d", hour, minute)

            val classDetails = Bundle().apply {
                putString("ClassName", className)
                putString("ClassLocation", classLocation)
                putString("ClassDate", classDate)
                putString("ClassTime", classTime)
            }

            val todoActivity = activity as ToDo
            todoActivity.receiveClassDetails(classDetails)

            requireActivity().supportFragmentManager.popBackStack()
        }
        return view
    }
}
