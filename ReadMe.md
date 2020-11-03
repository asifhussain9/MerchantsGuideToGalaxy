#Edge Cases:
######Assertions are placed before the questions
######Application to ensure valid Roman number
######Inputs to be provided via inputs.txt file

#objects identified:
###Enum Roman
    contains all the roman digits
###Calculator
    calculates value of an intergalactic number/material
######state:
            interGalacticDictionary, materialValueMap
######behavior:                        
            double calculate(Question question)

###AssertionParser
    Parses an assertion and updates intergalactic dictionary
######behavior:
            map parse(String assertion)

###OrnamentParser
    Parses an statement to infer the value of an ornament
######behavior:
            map parse(String statement)
            
###QuestionParser
    Parses question statement into a Question object
######behavior:
            Question parse(String question)

###Question
######state:
            interGalacticNumber
            material