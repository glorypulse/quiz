# GCJ 2013 QR C.Fair and Square
two_digit = [1,4,9,121,484]


test_case = gets.strip.to_i

for t_i in 1..test_case
  count = 0
  a_s, b_s = gets.strip.split(" ").map{|s| s.to_i}
  
  for i in 0..(two_digit.length - 1)
    if a_s > two_digit[i] then
      next
    end
    if b_s < two_digit[i] then
      break
    end
    count = count + 1
  end

  puts "Case ##{t_i}: #{count}"

end
