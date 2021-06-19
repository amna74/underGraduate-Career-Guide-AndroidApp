package com.example.undergradcareerguide.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;

public class UniMedActivity extends AppCompatActivity {

    TextView uni,des,elig;
    ImageView uniImage;
    Button link;

    String[][] medUni={
            {"University of Engineering and Technology (UET)", "COMSATS Institute of Information Technology, Islamabad", "National University Of Sciences And Technology (NUST), Islamabad", "FAST University, Islamabad", "Quaid-i-Azam University, Islamabad " ,  " University of Agriculture Faisalabad", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "RIPHAH International University (Islamabad)", "University of Veterinary and Animal Sciences (Lahore)", "Dha Suffa University, Karachi", "Pakistan Institute of Engineering & Applied Sciences (PIEAS), Islamabad" , "Institute of Space Technology (IST), Islamabad " , " Government College University, Lahore" , " Information Technology University, Lahore " , " Indus University, Karachi " ,"Dawood University of Engineering & Technology, Karachi" ,"National Textile University Faisalabad | NTU" , "University Of Central Punjab Lahore" , "NED University of Engineering & Technology, Karachi" ,"Punjab University College of Information Technology (PUCIT), Lahore"},

            {String.valueOf(R.drawable.uet) ,String.valueOf(R.drawable.comsats),String.valueOf(R.drawable.nust),String.valueOf(R.drawable.fast),String.valueOf(R.drawable.giki), String.valueOf(R.drawable.agri),String.valueOf(R.drawable.arid),String.valueOf(R.drawable.riphah),String.valueOf(R.drawable.veternity),String.valueOf(R.drawable.suffa), String.valueOf(R.drawable.pieas),String.valueOf(R.drawable.ist),String.valueOf(R.drawable.gcu),String.valueOf(R.drawable.ituni),String.valueOf(R.drawable.indus),String.valueOf(R.drawable.dawood),String.valueOf(R.drawable.ntu),String.valueOf(R.drawable.ucp),String.valueOf(R.drawable.ned),String.valueOf(R.drawable.pucit)},

            {"The University of Engineering and Technology, Lahore (UET Lahore) is a public university located in Lahore, Punjab, Pakistan specializing in science, technology, engineering and mathematics (STEM) subjects.It is the oldest and one of the most selective engineering institutions in Pakistan.\n\nPhone_No: (042) 99029216" ,  "The COMSATS University Islamabad (CUI), formerly known as COMSATS Institute of Information Technology (CIIT), is a public university in Pakistan. It is a multi-campus university with its principal seat located in Islamabad. In the latest QS Subject Rankings 2021, Electrical and Chemical Engineering at COMSATS is ranked # 1 in Pakistan. COMSATS University Islamabad (CUI) is under the administration of Commission on Science and Technology for Sustainable Development in the SouthThis university was ranked among top 250 Asian Universities by QS University Rankings in 2014 and nationally it is ranked top-most in Computer Sciences and IT category and 1st overall in the country according to NatureIndex. CIIT is ranked amongst the top 10 universities of Pakistan as per HEC recent rankings. \n\nPhone_No: (92-51) 9049 5032-5",          "With one of the best infrastructure and an excellent startup culture, NUST is the top-most priority for a career in Electrical Engineering. NUST was established in 1991 as a higher education institute with a focus on science and technology. It received the charter in 1993. Over the years, the university has expanded it’s scope, vision, services and stature. It has become a leading research institute and one of the best electrical engineering university in Pakistan. \n\nPhone_No: (051) 111 116 878" ,        "The university has five campuses based in different cities and was the first multi-campus university in Pakistan.These campuses located in Chiniot-Faisalabad, Islamabad, Karachi, Lahore and Peshawar. It was inaugurated by President Pervez Musharraf in 2000. It is consistently ranked among the leading institutions of higher education in the country and top in computer sciences and information technology by the Higher Education Commission of Pakistan in 2010.Its engineering programs have been accredited with Pakistan Engineering Council.It also give financial aid to their students based on Qarz-e-Hasna (Interest free loan) by Open Source Applications Foundation (OSAF).  \n\nPhone_No: (051) 111 128 128", "Quaid-I-Azam University Islamabad (commonly referred to as QAU), founded as University of Islamabad, is a public research university in Islamabad, Pakistan.Founded as the University of Islamabad in 1967, it was initially dedicated to the study of postgraduate education but expanded through the 1980s to an interdisciplinary university offering undergraduate and postgraduate education.The university has, as of 2015, grown into the largest varsity in Islamabad with a total enrollment exceeding 13,000 students. The university is on a 1700 acres (or 6.9 km²) campus on the foothills of the Margalla. \n\nPhone_No: (051) 90644050", 			"The University of Agriculture (UAF) is a public research university in Faisalabad, Pakistan. UAF is the Oldest and Pioneer Agriculture Institute in the South Asia. It is ranked 4th in Pakistan and 1st in the field of Agriculture and Veterinary Sciences by Higher Education Commission (Pakistan) (HEC) Ranking in 2019.[2][3] It was also ranked at No.127 in life Science and Agriculture Science (Shanghai Ranking 2019). The employability ranking by Pakistan made this institution highly reputable. The university came among top 5 institutions of Pakistan in research power. Muhammad Ashraf is serving as Vice Chancellor of the University\n\nPhone_No: +92 41 9200161-70" , " Pir Mehr Ali Shah Arid Agriculture University, Rawalpindi (PMAS-Arid University) is in Rawalpindi, Punjab, Pakistan. It is named after Pir Meher Ali Shah, a known Hanafi scholar leading the anti-Ahmadiyya movement.The university is ranked at No. 2 in Agriculture/Veterinary category as per the HEC and 7th overall in ranking of universities in Pakistan \n\nPhone_No: +92-51-9062113 " , " Riphah International University is a private university in Pakistan, chartered by the Federal Government of Pakistan in 2002.[1] The university was established with the aim of producing professionals with Islamic moral and ethical values. \n\nPhone_No: (051) 8446000" , " The University of Veterinary and Animal Sciences (UVAS), originally known as Lahore Veterinary College, is a public university located in Lahore, Punjab, Pakistan.[3] It is accredited by the Pakistan Veterinary Medical Council (PVMC).[4] It has additional teaching campuses in rural areas of the Punjab, Pattoki and Jhang.  \n\nPhone_No: (042) 99211374 " , "Establish strong faculties in the disciplines of Engineering, Management, Medical Sciences, Humanities and Social Sciences, Liberal Arts.Provide state of the art teaching and learning facilities for the students to achieve academic excellence at par with any world-class university. \n\nPhone_No:  021-35244851-2 ","The Pakistan Institute of Engineering and Applied Sciences, is a public research university located in Islamabad, Pakistan. The university is modelled on international standards with a strong focus on the scientific advancement of the nuclear science-related STEM fields and medical sciences.  \n\nPhone_No:  +92 (51) 1111 7432","The Institute of Space Technology is a public university located in Islamabad, Pakistan under the administration of Space and Upper Atmosphere Research Commission. It is focused on the study of astronomy, aerospace engineering and astronautics. \n\nPhone_No:   92.51.9075500","The institute was established as a primary school in 1897 in the present building of Government College for Women, Karkhana Bazar,Lahore. It was promoted to high school and intermediate college in 1905 and 1924 respectively. \n\nPhone_No:  (041) 9200066","Information Technology University, located in Lahore, came into being in 2012 in order to advance scholarship and innovation in the areas of science, technology and engineering. \n\nPhone_No: (041) 9200066","Indus University, formerly Indus Institute of Higher Education, is a university in Pakistan. It is chartered by the government of Sindh and ranked with the top most category by the Higher Education Commission of Pakistan. In 2013 CIEC of Pakistan placed Indus University in list of 5 Star Universities of Pakistan \n\nPhone_No:  021 34801430-35","The Dawood University of Engineering and Technology is a public university located in Karachi, Sindh, Pakistan. It was established by Dawood Foundation and is named after Seth Ahmed Dawood.\n\nPhone_No:  (021) 99231195" ,"The campus is spread over an area of 62 acres. The university is in the outskirts of city of Faisalabad, about 12 km from the city center on Sheikhupura road.[2] National Textile University is accredited by the Pakistan Engineering Council (PEC) and National Technology Council (NTC) and recognized by the Higher Education Commission of Pakistan (HEC).\n\nPhone_No:   (041) 9230090" ,"University of Central Punjab (UCP) has a student body of more than 10,000 and a highly trained teaching staff of around 400. A 2-year program of MS Civil Engineering (MS CEng) is offered at UCP. This consists of 10 courses and 30 credit hours. The total fee for this program is 340,000 Rupees. \n\nPhone_No:  (042) 35880007" ,"The NED University of Engineering & Technology was established in March 1977 under an act of the Provincial Assembly of Sindh after upgrading of the former NED Government Engineering College, which was set up in 1921. The NED University is thus one of the oldest institutions in Pakistan for teaching and is the Best Electrical Engineering University in Sindh. \n\nPhone_No:  (021) 99261261" ,"Punjab University College of Information Technology (PUCIT) is a college of computer science and information technology at the University of the Punjab located in Lahore, Pakistan. The college is located on the university's Allama Iqbal Campus (Old Campus) in Bahawalpur Block near old Anarkali and PUCIT Quaid-i-Azam Campus (New Campus) is located on Syed Kabeer Ali Shah road, Canal Bank, Lahore.  \n\nPhone_No:  99210885"},

            {"Eligibility Criteria\n\n Matric 10%\n60% marks in F.Sc\natleast 60% adjusted admission marks", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS","Eligibility Criteria\n\n atleast 50 accumulative test score or GRE (General) conducted by ETS, USA\n 40% F.Sc\n atleast 50% NTS", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS" , "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS", "Eligibility Criteria\n\n Matric 10%\n 60% marks in F.Sc\n atleast 60% adjusted admission marks", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS","Eligibility Criteria\n\n atleast 50 accumulative test score or GRE (General) conducted by ETS, USA\n 40% F.Sc\n atleast 50% NTS", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS" , "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS", "Eligibility Criteria\n\n Matric 10%\n60% marks in F.Sc\natleast 60% adjusted admission marks", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS","Eligibility Criteria\n\n atleast 50 accumulative test score or GRE (General) conducted by ETS, USA\n 40% F.Sc\n atleast 50% NTS", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS" , "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS", " Eligibility Criteria\n\n Matric 10%\n60% marks in F.Sc\natleast 60% adjusted admission marks", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS","Eligibility Criteria\n\n atleast 50 accumulative test score or GRE (General) conducted by ETS, USA\n 40% F.Sc\n atleast 50% NTS", "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS" , "Eligibility Criteria\n\n Matric 10%\n40% F.Sc\natleast 50% NTS"},

        {"http://www.uet.edu.pk", "http://admissions@comsats.edu.pk", "http://nust.edu.pk" , "http://admissions.isb@nu.edu.pk" , "http://info@qau.edu.pk","http://www.uaf.edu.pk" , "http://www.uaar.edu.pk " , "http://admiadmissions@riphah.edu.pk ", "http://webmaster@uvas.edu.pk" , "http://aneela.mansoor@dsu.edu.pkc ", "http://registrar@pieas.edu.pk", "http://amer.qazi@ist.edu.pk", "http://info@gcuf.edu.pk ","http://info@gcuf.edu.pk ","http://admission@indus.edu.pk ", "http://registrar@duet.edu.pk", "http://info@ntu.edu.pk", "http://admissions@ucp.edu.pk", "http://registrar@neduet.edu.pk" ,"http://webmaster@pucit.edu.pk" }

        };



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_med);

        uni = findViewById(R.id.titleTextVIew);
        uniImage = findViewById(R.id.imageUniMed);
        des = findViewById(R.id.desUniMed);
        elig = findViewById(R.id.elegUniMed);
        link = findViewById(R.id.linkBtn);

        int check=0;

        while(check<medUni[0].length)
        {
            if(FieldCustomAdapter.namesss.equals(medUni[0][check]))
            {



                int i =0;
                int j = check;


                uni.setText(medUni[i][j]);
                String imageRes = medUni[i + 1][j];
                uniImage.setImageResource(Integer.parseInt(imageRes));
                des.setText(medUni[i + 2][j]);
                elig.setText(medUni[i + 3][j]);

                String linkUniBtn = medUni[i + 4][j];


                link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String jerry=linkUniBtn;
                        Uri webaddress =Uri.parse(jerry);
                        Intent gotojerry = new Intent(Intent.ACTION_VIEW,webaddress);

                        startActivity(gotojerry);



                    }
                });

            }

            check++;


        }


    }
}