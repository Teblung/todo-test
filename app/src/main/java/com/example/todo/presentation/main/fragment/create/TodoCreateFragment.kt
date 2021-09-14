package com.example.todo.presentation.main.fragment.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.todo.CreateTodoSealed
import com.example.todo.R
import com.example.todo.databinding.FragmentCreateTodoBinding
import com.example.todo.presentation.main.MainViewModel
import com.example.todo.utils.DialogUtils
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class TodoCreateFragment : Fragment() {

    /**
     * TODO ("Lakukan initialized pada value dibawah ini")
     * */
    private lateinit var mainViewModel: MainViewModel
    private var mBinding: FragmentCreateTodoBinding? = null
    private val binding get() = mBinding as FragmentCreateTodoBinding
    private lateinit var mMaps: MapView
    private var mTodoId: Int? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCreateTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            fragmentLiveDataState()
            registerLiveData()
            initMap()
            getTodoById()
        }
    }

    private fun registerLiveData() {
        mainViewModel.observerLatLng.observe(viewLifecycleOwner, {
            val geoPoint = GeoPoint(it.latitude, it.longitude)
            generateOverlay(geoPoint)
        })
        mainViewModel.observerDate.observe(viewLifecycleOwner, {
            binding
                    .invalidateAll()
        })
    }

    private fun initMap() {
        mMaps = binding.osmdroid
        mMaps.controller.setZoom(14.0)
        mMaps.setBuiltInZoomControls(false)
        mMaps.setMultiTouchControls(true)
    }

    private fun generateOverlay(geoPoint: GeoPoint) {
        TODO(
                "Buatlah marker untuk menampilkan koordinat todo pada maps," +
                        "Marker yang tampil di maps hanya boleh satu"
        )
    }

    private val eventsReceiver: MapEventsReceiver by lazy {
        TODO(
                "Buatlah interaksi user dengan maap, ketika user melakukan longpress." +
                        "Buatlah sebuah marker berdasarkan koordinat yang user tekan dan marker di maps hanya boleh satu"
        )
    }


    private fun fragmentLiveDataState() {
        mainViewModel.observerSave.observe(viewLifecycleOwner, {
            when (it) {
                is CreateTodoSealed.OnProgressGet -> binding.getOnProgress = true
                is CreateTodoSealed.OnProgressSave -> binding.saveOnProgress = true
                is CreateTodoSealed.OnSaveSuccess -> {
                    binding.saveOnProgress = false
                    mainViewModel.getTodoList()
                    Navigation.findNavController(binding.root)
                            .navigate(R.id.action_todoCreateFragment_to_todoListFragment)
                }
                is CreateTodoSealed.OnGetSuccess -> {
                    binding.getOnProgress = false
                    binding.todo = it.todo
                }
                is CreateTodoSealed.OnFailure -> onError(it.err)
            }
        })
    }

    private fun onError(e: Throwable) {
        binding.getOnProgress = false
        binding.saveOnProgress = false
        DialogUtils.alertDialogError(requireContext(), e)
    }

    private fun getTodoById() {
        mainViewModel.getTodoById(mTodoId!!)
    }
}