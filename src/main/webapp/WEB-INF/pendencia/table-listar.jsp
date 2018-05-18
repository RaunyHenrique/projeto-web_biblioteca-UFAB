<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
			<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
				<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
					<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					
					<!-- Table -->
					<table id="table-listar-datatable" class="table table-hover table-condensed table-striped table-bordered" style="width:100%">

						<thead>

							<tr class="text-center">

								<td style="width: 5%">Matricula</td>
								<td style="width: 20%">Aluno</td>
								<td style="width: 20%">Itens</td>
								<td style="width: 10%">Dias de atraso</td>
								<td style="width: 10%">Valor da multa</td>
								<td style="width: 30%">Ações</td>

							</tr>

						</thead>

						<tbody>

							<c:forEach items="${pendencias}" var="pendencia">

								<tr data-id="${pendencia.id}">

									<td>${pendencia.aluno.matricula}</td>
									<td>${pendencia.aluno.nome}</td>
									<td>
									
										<c:forEach items="${pendencia.items_emprestados}" var="item_emprestado">
											${item_emprestado.titulo}
										</c:forEach>
										
									</td>

									<td>
									
										<jsp:useBean id="now" class="java.util.Date" scope="request"/>
										
										<fmt:formatDate value="${pendencia.data_emprestimo}" var="dataEmprestimo" pattern="yyyy-MM-dd"/>
										<fmt:parseDate value="${dataEmprestimo}" var="pd1" pattern="yyyy-MM-dd" />
										
										<fmt:formatDate value="${now}" var="dataAtual" pattern="yyyy-MM-dd"/>
										<fmt:parseDate value="${dataAtual}" var="pd2" pattern="yyyy-MM-dd" />
									
										<fmt:parseNumber
										    value="${ pd2.time / (1000*60*60*24) }"
										     var="nowDays" scope="request"/>
										
										<fmt:parseNumber
										    value="${ pd1.time / (1000*60*60*24) }"
										     var="otherDays" scope="page"/>
										
										<fmt:parseNumber
										    value="${(nowDays - otherDays) / 10000}"
										     var="dateDiff" scope="page"/>
										    														 													
										${dateDiff} dia(s) atrás

									</td>
									
									<td>
										<fmt:setLocale value="pt_BR"/>
										<fmt:formatNumber value="${pendencia.items_emprestados.size() * multa * dateDiff}" type="currency"/>
									</td>

									<td class="text-center">
										<button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modal-add-edit" data-tipo="Editar">
										<span class="glyphicon glyphicon-edit"></span> Editar</button>
										<button type="button" class="btn btn-danger btn-deletar">
										<span class="glyphicon glyphicon-trash"></span> Deletar</button>
										<button type="button" class="btn btn-primary">
										<span class="glyphicon glyphicon-ok"></span> Quitar pendência</button>
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>