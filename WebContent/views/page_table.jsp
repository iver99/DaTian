<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="0" cellpadding="0" cellspacing="0"
	class="table_pagenumber" id="PageNow" value="1">
	<tr>
		<td width="45" class="td_pagenumber" onclick="ChangeTo('first')"><a
			href="javascript:;" class="a_pagenumber" hidefocus="true">首页</a></td>
		<td width="45" class="td_pagenumber" onclick="ChangeTo('previous')"><a
			href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
		<c:if test="${pageNum < 8}">
			<c:forEach begin="1" end="${pageNum }" var="i">
				<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
					href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
			</c:forEach>
		</c:if>
		<c:if test="${pageNum >= 8}">
			<c:choose>
				<c:when test="${pageNow <= 3}">
					<c:forEach begin="1" end="5" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
                        			...
                        		</c:when>
				<c:when test="${pageNow == 4}">
					<c:forEach begin="1" end="6" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
                        			...
                        		</c:when>
				<c:when test="${pageNow == 5}">
					<c:forEach begin="1" end="7" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
                        			...
                        		</c:when>
				<c:when test="${pageNow > 5 && pageNow < pageNum - 3}">
					<td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a
						href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
					<td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a
						href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-2 }"
						end="${pageNow+2 }" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
                        			...
                        		</c:when>
				<c:when test="${pageNow == pageNum - 3}">
					<td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a
						href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
					<td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a
						href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-5 }"
						end="${pageNow }" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
				</c:when>
				<c:when test="${pageNow >= pageNum - 2}">
					<td width="30" class="td_pagenumber" onclick="ChangePage('1')"><a
						href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
					<td width="30" class="td_pagenumber" onclick="ChangePage('2')"><a
						href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        		    ...
                        			<c:forEach begin="${pageNow-4 }"
						end="${pageNow }" var="i">
						<td width="30" class="td_pagenumber" onclick="ChangePage(${i })"><a
							href="javascript:;" class="a_pagenumber" hidefocus="true">${i }</a></td>
					</c:forEach>
				</c:when>
			</c:choose>
		</c:if>
		<td width="45" class="td_pagenumber" onclick="ChangeTo('next')"><a
			href="javascript:;" class="a_pagenumber" hidefocus="true">下页</a></td>
		<td width="45" class="td_pagenumber" onclick="ChangeTo('last')"><a
			href="javascript:;" class="a_pagenumber" hidefocus="true">末页</a></td>
	</tr>
</table>