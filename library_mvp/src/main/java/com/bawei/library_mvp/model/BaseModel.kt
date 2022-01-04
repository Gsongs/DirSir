package com.bawei.library_mvp.model
open abstract
/**
 *作者：王先生
 *时间：2021/12/9 14:28
 *用途：对于Model层也是数据层。它区别于MVC架构中的Model，在这里不仅仅只是数据模型。
 * 在MVP架构中Model它负责对数据的存取操作，例如对数据库的读写，网络的数据的请求等。
 */
class BaseModel :IModel{
    override fun destroy() {
    }
}