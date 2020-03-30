package com.example.dialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NuevAveriaDialogo extends DialogFragment {
    AlertDialog.Builder builder;
    OnNuevaAveriaListener mListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        builder =  new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo_nueva_averia, null));
        builder.setTitle("Nueva avería")
                .setPositiveButton("Guardar",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Avería guardada", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                        mListener.onAveriaGuardarClickListener();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
           mListener = (OnNuevaAveriaListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException((context.toString()+" must implement OnNuevaAveriaListener"));
        }
    }
}
