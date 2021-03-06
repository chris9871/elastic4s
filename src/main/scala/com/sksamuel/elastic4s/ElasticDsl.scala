package com.sksamuel.elastic4s

import com.sksamuel.elastic4s.admin.SnapshotDsl
import com.sksamuel.elastic4s.source.ObjectSource

import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._
import com.sksamuel.elastic4s.mappings.MappingDsl

/** @author Stephen Samuel */
trait ElasticDsl
    extends IndexDsl
    with AliasesDsl
    with BulkDsl
    with ClusterDsl
    with CountDsl
    with CreateIndexDsl
    with DeleteIndexDsl
    with DeleteDsl
    with ExplainDsl
    with FacetDsl
    with AggregationDsl
    with GetDsl
    with IndexStatusDsl
    with MappingDsl
    with MoreLikeThisDsl
    with MultiGetDsl
    with OptimizeDsl
    with PercolateDsl
    with PutMappingDsl
    with SearchDsl
    with ScoreDsl
    with SnapshotDsl
    with UpdateDsl
    with ValidateDsl {

  implicit val duration: Duration = 10.seconds

  implicit class RichFuture[T](future: Future[T]) {
    def await(implicit duration: Duration = 10.seconds) = Await.result(future, duration)
  }

  implicit def product2source(obj: Product): ObjectSource = ObjectSource(obj)
}

object ElasticDsl extends ElasticDsl
