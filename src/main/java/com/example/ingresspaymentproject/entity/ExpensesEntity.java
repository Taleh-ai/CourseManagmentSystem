package com.example.ingresspaymentproject.entity;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
  @Table(name = "expenses")
public class ExpensesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  private String expensesName;
  private String description;
  private int amount;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date expensesDate;
  @Lob
  private byte[] expensesImage;
}
