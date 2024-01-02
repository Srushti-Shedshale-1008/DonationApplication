package com.example.donation.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.donation.Form;
import com.example.donation.MainActivity;
import com.example.donation.OptionsActivity;
import com.example.donation.R;
import com.example.donation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    static ImageView blood,organ,cloths,food,other;
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
ImageView iv;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;

        }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;


    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*blood=findViewById(R.id.blood);
        organ=findViewById(R.id.organ);
        cloths=findViewById(R.id.clothes);
        food=findViewById(R.id.food);
        other=findViewById(R.id.other);*/

    }
}