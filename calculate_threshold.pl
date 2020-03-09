:-dynamic second_first_term_grade/2.
:-dynamic second_second_term_grade/2.
:-dynamic third_cs_first_term_grade/2.
:-dynamic third_cs_second_term_grade/2.
:-dynamic third_ct_first_term_grade/2.
:-dynamic interest/2.

%confirm the interest with threshold
confirm_specific_interest(Interest,Threshold):-
    interest(Interest, InterestLevel),
    (InterestLevel >= Threshold -> true).

confirm_other_interest(Interest,Threshold):-
    interest(Interest, InterestLevel), 
    ((InterestLevel < Threshold) -> true);
    ((InterestLevel = Threshold)  -> false).

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


confirm_same_interestLevel_CT(I1, I2, I3, I4, Threshold) :-
    interest(I1, InterestLevel1),
    interest(I2, InterestLevel2),
    interest(I3, InterestLevel3),
    interest(I4, InterestLevel4),

    ((InterestLevel1 = Threshold) -> true),
    ((InterestLevel2 = Threshold) -> true),
    ((InterestLevel3 = Threshold) -> true),
    ((InterestLevel4 = Threshold) -> true).



third_ct_first_confirm_grade(Unit, Threshold):-
    third_ct_first_term_grade(Unit, GradePoints), GradePoints >= Threshold.


% Confirms whether any of the units provided meets the specified threshold
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
