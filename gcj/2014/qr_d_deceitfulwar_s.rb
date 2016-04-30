# -*- coding: utf-8 -*-
# GCJ 2014 QR A. Magic Trick

require "bigdecimal"

DIG = 15

ZERO = BigDecimal("0", DIG)
ONE = BigDecimal("1", DIG)
TWO = BigDecimal("2", DIG)


test_case = gets.chomp.to_i

for t_i in 1..test_case
  b_n = gets.chomp.to_i
  naomi = gets.chomp.split(" ").sort
  ken = gets.chomp.split(" ").sort

  dec_count = 0
  ken_i = 0
  b_n.times do |i|
    nao_i = i
    if (naomi[nao_i].to_f > ken[ken_i].to_f) then
      dec_count = dec_count + 1
      ken_i = ken_i + 1
    end
  end

  war_count = 0
  nao_i = 0
  b_n.times do |i|
    ken_i = i
    if (ken[ken_i].to_f > naomi[nao_i].to_f) then
      nao_i = nao_i + 1
    else
      war_count = war_count + 1
    end
  end


  print "Case ##{t_i}: "

  puts "#{dec_count} #{war_count}"
  
end


