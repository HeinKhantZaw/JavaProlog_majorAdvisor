% ke = knowledge_engineering,
% se = software_engineering,
% bis = business_information_system,
% hpc = high_performance_computing


tree_cs :-
   
    should_take(knowledge_engineering) -> true, (       
        should_take(software_engineering) -> true,( % SE
            
            should_take(high_performance_computing) -> true, ( % HPC
                
                should_take(business_information_system) -> true, ( % BIS
                    write("You should choose \n1. Knowledge Engineering \n2. Software Engineering \n3. Business Information System \n4. High Performance Computing"),
                    info(business_information_system), info(software_engineering), info(business_information_system), info(high_performance_computing), quit
                );

                ( % BIS -> False
                    % show(knowledge_engineering, high_performance_computing, software_engineering)
                    write("You should choose \n1. Knowledge Engineering \n2. Software Engineering \n3. High Performance Computing"),
                    info(knowledge_engineering), info(software_engineering), info(high_performance_computing), quit
                )
            );
            
            ( % IF HPC -> false
                should_take(business_information_system) -> true, (     
                    % show(knowledge_engineering, software_engineering, business_information_system)
                    write("You should choose \n1. Knowledge Engineering \n2. Software Engineering \n3. Business Information System"),
                    info(knowledge_engineering), info(software_engineering), info(business_information_system), quit
                );

                ( % If BIS -> False
                    % show(knowledge_engineering, software_engineering)       
                    write("You should choose \n1. Knowledge Engineering \n2. Software Engineering"),
                    info(knowledge_engineering), info(software_engineering), quit
                )

            )
        );
        ( % %IF SE -> false
            should_take(high_performance_computing) -> true, (
                
                should_take(business_information_system) -> true, (
                    % show(knowledge_engineering, high_performance_computing, business_information_system)
                    write("You should choose \n1. Knowledge Engineering \n2. High Performance Computing \n3. Business Information System"),
                    info(knowledge_engineering), info(high_performance_computing), info(business_information_system), quit
                );

                ( % If BIS -> false
                    % show(knowledge_engineering, high_performance_computing)
                    write("You should choose \n1. Knowledge Engineering \n2. High Performance Computing"),
                    info(knowledge_engineering), info(high_performance_computing), quit
                )
            );
            ( %If HPC -> false
                should_take(business_information_system) -> true, (
                
                    write("You should choose \n1. Knowledge Engineering \n2. Business Information System"),
                    info(knowledge_engineering), info(business_information_system), quit
                );

                ( %If BIS -> false
                    
                    write("You should choose \n1. Knowledge Engineering"),
                    info(knowledge_engineering), quit

                )
            )
        )
    );  

    ( % If KE -> false
        should_take(software_engineering) -> true,( 
            should_take(high_performance_computing) -> true, (
                should_take(business_information_system) -> true, (
                    % show(high_performance_computing, software_engineering, business_information_system)
                    write("You should choose \n1. Software Engineering \n2. High Performance Computing \n3. Business Information System"),
                    info(software_engineering), info(high_performance_computing), info(business_information_system),quit
                );
                ( % BIS -> False
                    % show(high_performance_computing, software_engineering)
                    write("You should choose \n1. Software Engineering \n2. High Performance Computing"),
                    info(software_engineering), info(high_performance_computing), quit
                )
            );
            ( % HPC -> false
                should_take(business_information_system) -> true, (
                    % show(software_engineering, business_information_system)
                    write("You should choose \n1. Software Engineering \n2. Business Information System"),
                    info(software_engineering), info(business_information_system), quit
                );
                ( % BIS -> False
                    write("You should choose \n1. Software Engineering "),
                    info(software_engineering), quit
                )

            )
        );
        ( % SE -> false
            should_take(high_performance_computing) -> true, (
                should_take(business_information_system) -> true, (
                    % show(high_performance_computing, business_information_system)
                    write("You should choose \n1. High Performance Computing \n2. Business Information System"),
                    info(high_performance_computing), info(business_information_system), quit
                );
                ( % BIS -> False
                  % show(high_performance_computing)
                  write("You should choose \n1. High Performance Computing"),
                  info(high_performance_computing), quit
                )
            );
            ( % HPC -> false
                should_take(business_information_system) -> true, (
                    
                    write("You should choose \n1. Business Information System"),
                    info(business_information_system), quit
                );
                ( % BIS -> false
                    sleep(1.5),
                    write('Analyzing Major . . .'),
                    write('\nSorry I cannot advice the major for you'),nl,nl,
                    quit    
                   
                )
            )
        )
     
    ). 
    
tree_ct :-
    should_take(computer_networking) -> true, (
        should_take(embedded_systems) -> true, (
            write("You should choose \n1. Computer Networking \n2. Embedded Systems"),
            info(computer_networking), info(embedded_systems), quit
            
        );
        ( % If ES -> false
            write("You should choose \n1. Computer Networking"),
            info(computer_networking), quit
        )
    );
    (% If CN -> false
        should_take(embedded_systems) -> true, (
            write("You should choose \n1. Embedded Systems "),
            info(embedded_systems), quit
            );
            sleep(1.5),
            write('Analyzing Major . . .'),
            write('\nSorry I cannot advice the major for you'),nl,nl,
            quit    
    ).
