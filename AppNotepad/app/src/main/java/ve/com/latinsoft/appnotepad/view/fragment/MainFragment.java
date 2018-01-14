package ve.com.latinsoft.appnotepad.view.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import ve.com.latinsoft.appnotepad.R;
import ve.com.latinsoft.appnotepad.view.Adapters.NotesAdapter;
import ve.com.latinsoft.appnotepad.view.POJOS.Note;

/**
 * Created by manue on 21/6/2017.
 */

public class MainFragment extends Fragment{
    RecyclerView recyclerView;
    ArrayList<Note> listOfNotes;
    NotesAdapter adapter ;
    FloatingActionButton fab;
    int idIncrement;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_layout,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.reciclerView);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        initializeData();
        adapter = new NotesAdapter(getActivity().getApplicationContext(),listOfNotes);
        recyclerView.setAdapter(adapter);
        idIncrement = listOfNotes.size() + 1;
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View _view) {
                AlertDialog.Builder alert =
                        new AlertDialog.Builder(getActivity());
                final EditText editText =
                        new EditText(getActivity());
                editText.setBackgroundColor(Color.GRAY);
               alert.setMessage("Agregar Elemento");
               alert.setTitle("Nombre del elemento");
               alert.setView(editText);
               alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       listOfNotes.add(new Note(idIncrement++,editText.getText().toString()," - "));
                       adapter.notifyDataSetChanged();
                       Toast.makeText(MainFragment.super.getActivity().getApplicationContext(),"Item agregado",Toast.LENGTH_SHORT).show();
                   }
               });

               alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainFragment.super.getActivity().getApplicationContext(),"Cancelado", Toast.LENGTH_SHORT).show();
                   }
               });

               alert.show();
                 }
        });
    }

    private void initializeData(){
        listOfNotes = new ArrayList<>();
        listOfNotes.add(new Note(1,"Nota 1","Este es el texto de la nota 1"));
        listOfNotes.add(new Note(2,"Nota 2","Este es el texto de la nota 2"));
        listOfNotes.add(new Note(3,"Nota 3","Este es el texto de la nota 3"));
        listOfNotes.add(new Note(4,"Nota 4","Este es el texto de la nota 4"));
        listOfNotes.add(new Note(5,"Nota 5","Este es el texto de la nota 5"));
        listOfNotes.add(new Note(6,"Nota 6","Este es el texto de la nota 6"));
        listOfNotes.add(new Note(7,"Nota 7","Este es el texto de la nota 7"));
        listOfNotes.add(new Note(8,"Nota 8","Este es el texto de la nota 8"));
        listOfNotes.add(new Note(9,"Nota 9","Este es el texto de la nota 9"));
        listOfNotes.add(new Note(10,"Nota 10","Este es el texto de la nota 10"));
        listOfNotes.add(new Note(11,"Nota 11","Este es el texto de la nota 11"));
        listOfNotes.add(new Note(12,"Nota 12","Este es el texto de la nota 12"));
        listOfNotes.add(new Note(13,"Nota 13","Este es el texto de la nota 13"));
        listOfNotes.add(new Note(14,"Nota 14","Este es el texto de la nota 14"));
        listOfNotes.add(new Note(15,"Nota 15","Este es el texto de la nota 15"));
    }
}
