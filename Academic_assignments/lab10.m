
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%  Programmers and Purdue Email Addresses:
%  1. singh178@purdue.edu
%  2. skishta@purdue.edu
%  3. rwidjaj@purdue.edu (delete line if no third partner) 
%
%  Lab #: 09
%
%  Academic Integrity Statement:
%
%       We have not used source code obtained from
%       any other unauthorized source, either modified
%       or unmodified.  Neither have we provided access 
%       to our code to another. The project we are submitting
%       is our own original work.
%
%  Lab Division and Section:1801
%
%  Program Description:The program reads the input from a file and checks if the number is 
%   prime and then prints its factors.
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

fTest = fopen('labData', 'r');              % file handle

if(fTest == -1)
  fprintf('File failed to open\n');
else
  if(fTest ~= -1)
    while(~feof(fTest))
      num = fscanf(fTest, '%d', 1);         % the variable stores the input from the external file 
      prime = 1;                            % the variable to test for number being a prime
      for lcv = 2 : 1 : sqrt(num)           % lcv is the loop control variable
        if( mod(num, lcv) == 0)
          prime = 0;
        end
      end
      if(prime == 1)

        if(~feof(fTest))
        fprintf('The number (%d) cannot be prime factorized.\n', num);
        end

      else
        fprintf('Prime factors of %d: ', num);
        factor = 2;                         % the variable stores the value of factor of the number
        while(num > 1) 
          if(mod(num, factor) == 0)
            
            fprintf('%d ', factor);

            num = num / factor;
            factor = 1;
          end
          factor = factor + 1;
        end
        fprintf('\n');
      end
     end
  end
  fclose(fTest);
end

