# GCJ 2013 QR B. Lawnmower

test_case = gets.strip.to_i

for t_i in 1..test_case
  n, m = gets.strip.split(" ").map{|s| s.to_i}

  array = []
  for i in 1..n
    array << gets.strip.split(" ").map{|s| s.to_i}
  end

  col_max = Array.new(n, 0)
  row_max = Array.new(m, 0)


  for i in 0..(n-1)
    for j in 0..(m-1)
      if array[i][j] > col_max[i] then
        col_max[i] = array[i][j]
      end
      if array[i][j] > row_max[j] then
        row_max[j] = array[i][j]
      end
    end
  end

  poss = "YES"
  for i in 0..(n-1)
    for j in 0..(m-1)
      if array[i][j] < col_max[i] and
          array[i][j] < row_max[j] then
        poss = "NO"
        break
      end
    end
    if poss == "NO" then
      break
    end
  end

  puts "Case ##{t_i}: #{poss}"

end
