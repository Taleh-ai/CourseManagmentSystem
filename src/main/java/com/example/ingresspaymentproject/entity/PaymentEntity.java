package com.example.ingresspaymentproject.entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "payments")
public class PaymentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String courseName;
  private int courseMonth
  private String studentName;
  private int amount;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date receiptDate;
  @Lob
  private byte[] receiptImage;
}
