# -*- coding: utf-8 -*-
# GCJ 2014 QR A. Magic Trick

test_case = gets.chomp.to_i

for t_i in 1..test_case
  first_row = gets.chomp.to_i
  first_cardset = []
  for i in 1..4
    if i == first_row then
      first_cardset = gets.chomp.split(" ")
    else
      gets
    end
  end

  second_row = gets.chomp.to_i
  second_cardset = []
  for i in 1..4
    if i  == second_row then
      second_cardset = gets.chomp.split(" ")
    else
      gets
    end
  end

  count = 0
  letter = ""
  first_cardset.each do |card|
    second_cardset.each do |s_card|
      if card == s_card then
        count = count + 1
        letter = card
      end
    end
  end

  print "Case ##{t_i}: "
  case count
    when 0 then
      puts "Volunteer cheated!"
    when 1 then
      puts letter
    else
      puts "Bad magician!"
  end
  
end


