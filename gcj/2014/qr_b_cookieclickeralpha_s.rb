# -*- coding: utf-8 -*-
# GCJ 2014 QR A. Magic Trick

require "bigdecimal"

DIG = 15

ZERO = BigDecimal("0", DIG)
ONE = BigDecimal("1", DIG)
TWO = BigDecimal("2", DIG)


test_case = gets.chomp.to_i

for t_i in 1..test_case
  line = gets.chomp.split(" ")
  c = BigDecimal(line[0], DIG)
  f = BigDecimal(line[1], DIG)
  x = BigDecimal(line[2], DIG)

  # n = ((x * f - TWO * c - c * f) / (c * f)).to_i
  n = ((x / c) - (TWO / f)).to_i
  if  n < 0  then
    n = 0
  end

  sum = ZERO
  for m in 1..n
    sum = sum + ONE / (TWO + BigDecimal(m.to_s, DIG) * f - f)
    temp = sum * c
  end

  second = x / (TWO + n * f) + c * sum

  print "Case ##{t_i}: "
  puts sprintf( "%.7f", second )
  
end


