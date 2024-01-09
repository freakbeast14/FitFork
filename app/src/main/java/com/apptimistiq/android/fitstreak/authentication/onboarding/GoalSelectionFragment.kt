package com.apptimistiq.android.fitstreak.authentication.onboarding

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.apptimistiq.android.fitstreak.FitApp
import com.apptimistiq.android.fitstreak.R
import com.apptimistiq.android.fitstreak.authentication.AuthenticationViewModel
import com.apptimistiq.android.fitstreak.authentication.GoalType
import com.apptimistiq.android.fitstreak.databinding.FragmentGoalSelectionBinding
import javax.inject.Inject


private const val WATER_GLASS_MAX = 100
private const val WATER_GLASS_MIN = 0
private const val SLEEP_HR_MAX = 24
private const val SLEEP_HR_MIN = 0

private const val LOG_TAG = "GoalSelectionFragment"

class GoalSelectionFragment : Fragment() {


    private lateinit var binding: FragmentGoalSelectionBinding

    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<AuthenticationViewModel> { viewModelFactory }

    private var stepCountGoal = 1000
    private var waterGlassesGoal = 0
    private var sleepHrsGoal = 0
    private var exerciseCalGoal = 100

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as FitApp).appComponent.authenticationComponent().create()
            .inject(
                this
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_goal_selection, container, false)
        // Inflate the layout for this fragment
        setUpStepCountPicker()
        setUpWaterGlassPicker()
        setUpSleepHourPicker()
        setUpExerciseCalPicker()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO: check if the goals have been selected and then navigate to home


        binding.goalSelectionDoneButton.setOnClickListener {
            viewModel.saveGoal(GoalType.STEP, stepCountGoal)
            viewModel.saveGoal(GoalType.WATER, waterGlassesGoal)
            viewModel.saveGoal(GoalType.SLEEP, sleepHrsGoal)
            viewModel.saveGoal(GoalType.EXERCISE, exerciseCalGoal)
            navigateToHomeDest()
            requireActivity().finish()
        }

    }

    //set up step count picker
//    private fun setUpStepCountPicker() {
//
//        binding.stepCountPicker.apply {
//
//            wrapSelectorWheel = true
//            val pickerValuesInt = List(491) { (it * 100) + 1000 }
//            val pickerValuesStr = pickerValuesInt.map { it.toString() }.toTypedArray()
//            minValue = 0
//            maxValue = pickerValuesStr.size - 1
//            displayedValues = pickerValuesStr
//
//            setOnValueChangedListener { picker, oldVal, newVal ->
//                Log.d(
//                    LOG_TAG,
//                    "step count goal has been selected with step count - ${((newVal * 100) + 1000)}"
//                )
//                stepCountGoal = ((newVal * 100) + 1000)
//
//            }
//        }
//    }

    private fun setUpStepCountPicker() {
        binding.stepSlider.apply {
            valueFrom = 1000f
            valueTo = 50000f
            stepSize = 100f
            value = stepCountGoal.toFloat()

            addOnChangeListener { slider, value, fromUser ->
                if (fromUser) { // If the change was made by the user
                    stepCountGoal = value.toInt()
                    Log.d(LOG_TAG, "Step count goal has been selected: $stepCountGoal")
                }
            }
        }
    }
    //set up water glass picker
//    private fun setUpWaterGlassPicker() {
//
//        binding.waterGlassPicker.apply {
//            minValue = WATER_GLASS_MIN
//            maxValue = WATER_GLASS_MAX
//            wrapSelectorWheel = true
//            setOnValueChangedListener { picker, oldVal, newVal ->
//                Log.d(LOG_TAG, "water goal has been selected with litres count - $newVal")
//                waterGlassesGoal = newVal
//
//            }
//        }
//
//    }

    private fun setUpWaterGlassPicker() {
        binding.waterSlider.apply {
            valueFrom = WATER_GLASS_MIN.toFloat()
            valueTo = WATER_GLASS_MAX.toFloat()
            stepSize = 1f
            value = waterGlassesGoal.toFloat()

            addOnChangeListener { slider, value, fromUser ->
                if (fromUser) {
                    waterGlassesGoal = value.toInt()
                    Log.d(LOG_TAG, "Water glass goal has been selected: $waterGlassesGoal")
                }
            }
        }
    }

    //set up sleep hour picker
//    private fun setUpSleepHourPicker() {
//
//        binding.sleepHourPicker.apply {
//            minValue = SLEEP_HR_MIN
//            maxValue = SLEEP_HR_MAX
//            wrapSelectorWheel = true
//            setOnValueChangedListener { picker, oldVal, newVal ->
//                Log.d(LOG_TAG, "Sleep goal has been selected with hours count - $newVal")
//                sleepHrsGoal = newVal
//
//            }
//        }
//    }

    private fun setUpSleepHourPicker() {
        binding.sleepSlider.apply {
            valueFrom = SLEEP_HR_MIN.toFloat()
            valueTo = SLEEP_HR_MAX.toFloat()
            stepSize = 1f
            value = sleepHrsGoal.toFloat()

            addOnChangeListener { slider, value, fromUser ->
                if (fromUser) {
                    sleepHrsGoal = value.toInt()
                    Log.d(LOG_TAG, "Sleep hour goal has been selected: $sleepHrsGoal")
                }
            }
        }
    }
    //set up exercise cal picker
//    private fun setUpExerciseCalPicker() {
//
//        binding.exerciseCalPicker.apply {
//            wrapSelectorWheel = true
//            val pickerValuesInt = List(60) { (it * 50) + 50 }
//            val pickerValuesStr = pickerValuesInt.map { it.toString() }.toTypedArray()
//            minValue = 0
//            maxValue = pickerValuesStr.size - 1
//            displayedValues = pickerValuesStr
//            setOnValueChangedListener { picker, oldVal, newVal ->
//                Log.d(
//                    LOG_TAG,
//                    "Exercise goal has been selected with calories count - ${((newVal * 50) + 50)}"
//                )
//                exerciseCalGoal = ((newVal * 50) + 50)
//
//            }
//        }
//    }

    private fun setUpExerciseCalPicker() {
        binding.exerciseSlider.apply {
            valueFrom = 50f
            valueTo = 3000f
            stepSize = 50f
            value = exerciseCalGoal.toFloat()

            addOnChangeListener { slider, value, fromUser ->
                if (fromUser) {
                    exerciseCalGoal = value.toInt()
                    Log.d(LOG_TAG, "Exercise calorie goal has been selected: $exerciseCalGoal")
                }
            }
        }
    }

    //Navigate to Home screen
    private fun navigateToHomeDest() {

        findNavController().navigate(GoalSelectionFragmentDirections.actionGoalSelectionFragmentToMainActivity())

    }
}