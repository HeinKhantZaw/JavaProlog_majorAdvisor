% ke = knowledge_engineering,
% se = software_engineering,
% bis = business_information_system,
% hpc = high_performance_computing


tree_cs :-
    should_take(knowledge_engineering) -> true, (
        should_take(software_engineering) -> true,( % SE

            should_take(high_performance_computing) -> true, ( % HPC

                should_take(business_information_system) -> true, ( % BIS
                    write("1. Knowledge Engineering \n2. Software Engineering \n3. Business Information System \n4. High Performance Computing"),
                    info(business_information_system)
                    );
                ( % BIS -> False
                    % show(knowledge_engineering, high_performance_computing, software_engineering)
                    write("1. Knowledge Engineering \n2. Software Engineering \n3. High Performance Computing")),
                info(business_information_system)
            );

            ( % IF HPC -> false
                should_take(business_information_system) -> true, (
                    % show(knowledge_engineering, software_engineering, business_information_system)
                    write("1. Knowledge Engineering \n2. Software Engineering \n3. Business Information System"),
                    info(business_information_system)
                );

                ( % If BIS -> False
                    % show(knowledge_engineering, software_engineering)
                    write("1. Knowledge Engineering \n2. Software Engineering"),
                    info(business_information_system)
                )

            )
        );
        ( % %IF SE -> false
            should_take(high_performance_computing) -> true, (

                should_take(business_information_system) -> true, (
                    % show(knowledge_engineering, high_performance_computing, business_information_system)
                    write("1. Knowledge Engineering \n2. High Performance Computing \n3. Business Information System"),
                    info(business_information_system)
                );

                ( % If BIS -> false
                    % show(knowledge_engineering, high_performance_computing)
                    write("1. Knowledge Engineering \n2. High Performance Computing"),
                    info(business_information_system)
                )
            );
            ( %If HPC -> false
                should_take(business_information_system) -> true, (

                    write("1. Knowledge Engineering \n2. Business Information System"),
                    info(business_information_system)
                );

                ( %If BIS -> false

                    write("1. Knowledge Engineering"),
                    info(business_information_system)

                )
            )
        )
    );

    ( % If KE -> false
        should_take(software_engineering) -> true,(
            should_take(high_performance_computing) -> true, (
                should_take(business_information_system) -> true, (
                    % show(high_performance_computing, software_engineering, business_information_system)
                    write("1. Software Engineering \n2. High Performance Computing \n3. Business Information System"),
                    info(business_information_system)
                );
                ( % BIS -> False
                    % show(high_performance_computing, software_engineering)
                    write("1. Software Engineering \n2. High Performance Computing"),
                    info(business_information_system)
              )
            );
            ( % HPC -> false
                should_take(business_information_system) -> true, (
                    % show(software_engineering, business_information_system)
                    write("1. Software Engineering \n2. Business Information System"),
                    info(business_information_system)
                );
                ( % BIS -> False
                    write("1. Software Engineering "),
                    info(business_information_system)
                )

            )
        );
        ( % SE -> false
            should_take(high_performance_computing) -> true, (
                should_take(business_information_system) -> true, (
                    % show(high_performance_computing, business_information_system)
                    write("1. High Performance Computing \n2. Business Information System"),
                    info(business_information_system)
                );
                ( % BIS -> False
                  % show(high_performance_computing)
                  write("1. High Performance Computing"),
                  info(business_information_system)
                )
            );
            ( % HPC -> false
                should_take(business_information_system) -> true, (

                    write("1. Business Information System"),
                    info(business_information_system)
                );
                ( % BIS -> false
                    sleep(1.5),
                    write('Analyzing Major . . .'),
                    write('\nSorry I cannot advice the major for you')
                )
            )
        )

    ).

tree_ct :-
    should_take(computer_networking) -> true, (
        should_take(embedded_systems) -> true, (
            write("1. Computer Networking \n2. Embedded Systems"),
            info(business_information_system)

        );
        ( % If ES -> false
            write("1. Computer Networking"),
            info(business_information_system)
        )
    );
    (% If CN -> false
        should_take(embedded_systems) -> true, (
            write("1. Embedded Systems "),
            info(business_information_system)
            );
            sleep(1.5),
            write('Analyzing Major . . .'),
            write('\nSorry I cannot advice the major for you')
    ).
