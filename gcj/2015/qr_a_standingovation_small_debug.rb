# -*- coding: utf-8 -*-
# GCJ 2014 QR A. Standing Ovation

test_case = gets.chomp.to_i

for t_i in 1..test_case
  # input_row = gets.chomp.to_i
  # inputs = gets.chomp.split(" ")
  (s_max, syness) = gets.chomp.split(" ")


  # for quiz
  s_max = s_max.to_i
  syness = syness.split("").map(&:to_i)
  
  standing_count = 0
  friend_count = 0

  puts "Case ##{t_i}: DEBUG"
  for i in 0..s_max
    print "turn #{i}:: sc#{standing_count}, fc#{friend_count}"
  puts
    
    if syness[i] != 0 then
      standing_count = standing_count + syness[i]
      next
    end

    # case syness[i] == 0

    if standing_count > s_max then break end

    if standing_count <= i then
      friend_count = friend_count + 1
      standing_count = standing_count + 1
    end
  end


  puts "-----------Case ##{t_i}: DEBUG"
  print "Case ##{t_i}: "
  
  print"#{friend_count}"
  puts

end


