package com.example.android.bottomsheetfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddPhotoBottomDialogFragment extends BottomSheetDialogFragment {


    BottomSheetDialog bottomSheetDialog;


    static AddPhotoBottomDialogFragment newInstance() {
        return new AddPhotoBottomDialogFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setupBottomSheetDialog();

        return inflater.inflate(R.layout.layout_photo_bottom_sheet, container,
                false);
    }

    private void setupBottomSheetDialog() {

        bottomSheetDialog = new BottomSheetDialog(requireContext()) {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                            // Back key is pressed

                            bottomSheetDialog.dismiss(); // Optional
                            requireActivity().moveTaskToBack(true); //exit the app when press back
                            requireActivity().finish();
                            return true;
                        }
                        return false;
                    }
                });

            }
        };

        bottomSheetDialog.setContentView(R.layout.bottomsheet_no_internet);
        bottomSheetDialog.setCancelable(false);

    }

    @Override
    public void onResume() {
        super.onResume();
        bottomSheetDialog.show();
    }
}