// PROBLEM: object not serializable (class: org.apache.spark.SparkContext, value: org.apache.spark.SparkContext@77ea806f)

Exception in thread "main" org.apache.spark.SparkException: Task not serializable
	at org.apache.spark.util.ClosureCleaner$.ensureSerializable(ClosureCleaner.scala:315)
	at org.apache.spark.util.ClosureCleaner$.org$apache$spark$util$ClosureCleaner$$clean(ClosureCleaner.scala:305)
	at org.apache.spark.util.ClosureCleaner$.clean(ClosureCleaner.scala:132)
	at org.apache.spark.SparkContext.clean(SparkContext.scala:1893)
	at org.apache.spark.rdd.RDD$$anonfun$flatMap$1.apply(RDD.scala:303)
	at org.apache.spark.rdd.RDD$$anonfun$flatMap$1.apply(RDD.scala:302)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
	at org.apache.spark.rdd.RDD.withScope(RDD.scala:286)
	at org.apache.spark.rdd.RDD.flatMap(RDD.scala:302)
	at com.vivo.bigdata.household.services.GraphServices.generateAddressTopErbEdges(GraphServices.scala:100)
Caused by: java.io.NotSerializableException: org.apache.spark.SparkContext
Serialization stack:
	- object not serializable (class: org.apache.spark.SparkContext, value: org.apache.spark.SparkContext@77ea806f)
	- field (class: com.vivo.bigdata.household.services.GraphServices, name: sc, type: class org.apache.spark.SparkContext)
	- object (class com.vivo.bigdata.household.services.GraphServices, com.vivo.bigdata.household.services.GraphServices@1b3a9ef4)
	- field (class: com.vivo.bigdata.household.services.GraphServices$$anonfun$10, name: $outer, type: class com.vivo.bigdata.household.services.GraphServices)
	- object (class com.vivo.bigdata.household.services.GraphServices$$anonfun$10, <function1>)

// SOLUTION: Add @transient to variable declaration

// @transient annotation prevents the variable sc to be serialized.
class GraphServices(config: HouseholdMiningConfig)(implicit @transient sc: SparkContext) extends Serializable {
...
}
// and make sure sc is not used within extract function, since it won't be available on workers.

// If it's necessary to access Spark context from within distributed computation, rdd.context function might be used:
val rdd = sc.textFile(...).map(...)

rdd map {
  case (k, v) => 
    val ctx = rdd.context
    ....
}