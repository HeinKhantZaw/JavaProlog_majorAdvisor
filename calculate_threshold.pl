:-dynamic second_first_term_grade/2.
:-dynamic second_second_term_grade/2.
:-dynamic third_cs_first_term_grade/2.
:-dynamic third_cs_second_term_grade/2.
:-dynamic third_ct_first_term_grade/2.
:-dynamic interest/2.

%confirm the interest with threshold if it is equal or more than threshold, interest level = true
%confirm_specific_interest is then called in kb.pl 

confirm_specific_interest(Interest,Threshold):-
    interest(Interest, InterestLevel),
    (InterestLevel >= Threshold -> true).


%this rule get value for each interest and Intrest level becomes true if it is equal or more than threshold

confirm_same_interestLevel_CS(I1, I2, I3, I4, I5, I6, I7, I8, Threshold) :-
    interest(I1, InterestLevel1),
    interest(I2, InterestLevel2),
    interest(I3, InterestLevel3),
    interest(I4, InterestLevel4),
    interest(I5, InterestLevel5),
    interest(I6, InterestLevel6),
    interest(I7, InterestLevel7),
    interest(I8, InterestLevel8),

    ((InterestLevel1 = Threshold) -> true),
    ((InterestLevel2 = Threshold) -> true),
    ((InterestLevel3 = Threshold) -> true),
    ((InterestLevel4 = Threshold) -> true),
    ((InterestLevel5 = Threshold) -> true),
    ((InterestLevel6 = Threshold) -> true),
    ((InterestLevel7 = Threshold) -> true),
    ((InterestLevel8 = Threshold) -> true).


confirm_same_interestLevel_CT(I1, I2, I3, I4,T5,T6,T7,T8 Threshold) :-
    interest(I1, InterestLevel1),
    interest(I2, InterestLevel2),
    interest(I3, InterestLevel3),
    interest(I4, InterestLevel4),
    interest(I5, InterestLevel1),
    interest(I6, InterestLevel2),
    interest(I7, InterestLevel3),
    interest(I8, InterestLevel4),

    ((InterestLevel1 = Threshold) -> true),
    ((InterestLevel2 = Threshold) -> true),
    ((InterestLevel3 = Threshold) -> true),
    ((InterestLevel4 = Threshold) -> true),
    ((InterestLevel5 = Threshold) -> true),
    ((InterestLevel6 = Threshold) -> true),
    ((InterestLevel7 = Threshold) -> true),
    ((InterestLevel8 = Threshold) -> true).



third_ct_first_confirm_grade(Unit, Threshold):-
    third_ct_first_term_grade(Unit, GradePoints), GradePoints >= Threshold.


% Confirms whether any of the units provided meets the specified threshold
% For eg, In order to recommend BIS, the student needs to pass the prerequisite subject in 2nd year and 3rd year

bis_any_meets_threshold(Unit1, Unit2, Unit3, Threshold) :-
    second_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    second_second_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_cs_first_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold.

ke_any_meets_threshold(Unit1, Unit2, Unit3, Threshold) :-
    second_second_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    third_cs_first_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_cs_first_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold.

se_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Threshold) :-
    second_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    second_second_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    second_second_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    third_cs_first_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold.

hpc_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Unit5, Threshold) :-
    second_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    second_second_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_cs_second_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    third_cs_second_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold;
    third_cs_second_term_grade(Unit5, Unit5Points), Unit5Points >= Threshold.
   
   

cn_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Threshold) :-
    second_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    third_cs_first_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_cs_second_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    third_cs_second_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold.
    

es_any_meets_threshold(Unit1, Unit2, Unit3, Threshold) :-
    third_cs_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    third_cs_first_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_ct_first_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold.

%get GPA of prerequisite subjects 
second_first_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Unit5, Threshold) :-
    second_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    second_first_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    second_first_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    second_first_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold;
    second_first_term_grade(Unit5, Unit5Points), Unit5Points >= Threshold.

second_second_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Unit5, Threshold) :-
    second_second_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    second_second_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    second_second_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    second_second_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold;
    second_second_term_grade(Unit5, Unit5Points), Unit5Points >= Threshold.

third_cs_first_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Unit5, Threshold) :-
    third_cs_first_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    third_cs_first_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_cs_first_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    third_cs_first_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold;
    third_cs_first_term_grade(Unit5, Unit5Points), Unit5Points >= Threshold.

third_cs_second_any_meets_threshold(Unit1, Unit2, Unit3, Unit4, Unit5, Threshold) :-
    third_cs_second_term_grade(Unit1, Unit1Points), Unit1Points >= Threshold;
    third_cs_second_term_grade(Unit2, Unit2Points), Unit2Points >= Threshold;
    third_cs_second_term_grade(Unit3, Unit3Points), Unit3Points >= Threshold;
    third_cs_second_term_grade(Unit4, Unit4Points), Unit4Points >= Threshold;
    third_cs_second_term_grade(Unit5, Unit5Points), Unit5Points >= Threshold.
