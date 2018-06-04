package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidproject_plant.R;

import java.util.List;

import entity.ConservationRecord;

public class ConservationRecordAdapter extends RecyclerView.Adapter<ConservationRecordAdapter.ConservationHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private List<ConservationRecord> conservationRecords;


    public ConservationRecordAdapter(Context context, List<ConservationRecord> conservationRecords){
        this.context=context;
        this.conservationRecords=conservationRecords;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return conservationRecords.size();
    }

    @Override
    public ConservationRecordAdapter.ConservationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.conservation_detail_record,parent,false);
        ConservationHolder holder=new ConservationHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ConservationRecordAdapter.ConservationHolder holder, int position) {
        ConservationRecord conservationRecord=null;

        for (int i=0;i<conservationRecords.size();i++){
            conservationRecord=conservationRecords.get(position);
        }

        holder.conservationAction.setText(conservationRecord.getConservationAction());
        holder.conservationTime.setText(conservationRecord.getConservationTime());
        holder.conservationPerson.setText(conservationRecord.getConservationPerson());
    }



    public class ConservationHolder extends RecyclerView.ViewHolder {

        private TextView conservationAction;
        private TextView conservationTime;
        private TextView conservationPerson;


        public ConservationHolder(View view) {
            super(view);
            conservationAction=(TextView)view.findViewById(R.id.conservationAction);
            conservationTime=(TextView)view.findViewById(R.id.conservationTime);
            conservationPerson=(TextView)view.findViewById(R.id.conservationPerson);
        }
    }
}
