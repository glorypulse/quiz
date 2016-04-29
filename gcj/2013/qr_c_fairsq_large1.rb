# GCJ 2013 QR C.Fair and Square
def calc(min_dig, max_dig, a, b)
  pattern = ["11", "22", "111", "121", "212", "1111","11111","111111","1111111"]
  count = 0
  zero_max_str = ""
  zero_min_str = ""
  for i in 1..(min_dig-2)
    zero_min_str << "0"
  end

  for i in 1..(max_dig-2)
    zero_max_str << "0"
  end
  

  #11,22
  if min_dig <= 2 then
    for i in 0..1
      count = max_dig - min_dig + 1
      if a > (pattern[i][0,1] + zero_min_str + pattern[i][pattern[i].length - 1, 1]).to_i then
        count = count -1
      end
      if b < (pattern[i][0,1] + zero_max_str + pattern[i][pattern[i].length - 1, 1]).to_i then
        count = count -1
      end
    end
  end
  
  if max_dig == 2 then return count end

  if min_dig <= 3 then
    #111,121,212
    for i in 2..4
      count = (max_dig - min_dig) / 2 + 1
      if min_dig % 2 != 0
        zero_min_str[zero_min_str.length/2, 1] = pattern[i][pattern.length/2,1]
        if a > (pattern[i][0,1] + zero_min_str + pattern[i][pattern[i].length - 1, 1]).to_i then
          count = count -1
        end
      end
      if max_dig % 2 != 0
        zero_max_str[zero_max_str.length/2, 1] = pattern[i][pattern.length/2,1]
        if a > (pattern[i][0,1] + zero_max_str + pattern[i][pattern[i].length - 1, 1]).to_i then
          count = count -1
        end
      end
    end
  end
  if max_dig == 3 then return count end


  if min_dig <= 4 then
  
end
two_digit = [1,4,9]




test_case = gets.strip.to_i

for t_i in 1..test_case
  count = 0
  a_s, b_s = gets.strip.split(" ")
  a = a_s.to_i; b = b_s.to_i
  
  if a_s.length < 2 then
    for i in 0..(two_digit.length - 1)
      if a > two_digit[i] then
        next
      end
      if b < two_digit[i] then
        break
      end
      count = count + 1
    end
  end

  min_dig = (a_s.length + 1)/ 2
  max_dig = (b_s.length + 1)/ 2

  #all 1
  count = count + max_dig - 1
  if b < allone[max_dig-2]
    count = count - 1
  end


  for dig in min_dig..max_dig
    # 2digit
    for i in 1..dig
      
    end
  end



  puts "Case ##{t_i}: #{count}"

end
