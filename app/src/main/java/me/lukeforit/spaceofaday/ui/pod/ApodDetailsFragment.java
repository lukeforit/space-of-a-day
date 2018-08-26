package me.lukeforit.spaceofaday.ui.pod;

import android.os.Bundle;
import android.text.TextUtils;

import me.lukeforit.spaceofaday.R;
import me.lukeforit.spaceofaday.common.Utils;
import me.lukeforit.spaceofaday.databinding.FragmentApodDetailsBinding;
import me.lukeforit.spaceofaday.ui.base.DIFragment;

public class ApodDetailsFragment extends DIFragment<ApodDetailsViewModel, FragmentApodDetailsBinding> {

    private static final String ARG_APOD_ID = "apod_id";

    private String apodId;

    public ApodDetailsFragment() {
    }

    public static ApodDetailsFragment newInstance(String apod) {
        ApodDetailsFragment fragment = new ApodDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_APOD_ID, apod);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            apodId = getArguments().getString(ARG_APOD_ID);
        }
        if (TextUtils.isEmpty(apodId)) {
            apodId = Utils.getDefaultDateAsString();
        }
        if (savedInstanceState == null) {
            viewModel.init(apodId);
        }
    }

    @Override
    protected Class<ApodDetailsViewModel> getViewModelClass() {
        return ApodDetailsViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_apod_details;
    }

    @Override
    protected void bind() {
        binding.setVm(viewModel);
    }
}
